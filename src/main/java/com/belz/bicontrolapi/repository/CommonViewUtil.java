package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.util.PageModel;
import com.belz.bicontrolapi.util.annotations.CommonConstructor;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.domain.*;

import java.lang.reflect.Field;
import java.util.*;
import javax.persistence.Id;
import java.util.logging.Logger;

public class CommonViewUtil<TEntity, TSearchCriteria> {

    private static final Logger LOGGER = Logger.getLogger(CommonViewUtil.class.getName());
    private final List<String> ATTRIBUTED;
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;
    private final Class<TEntity> entityClass;
    private String columnName;

    protected CommonViewUtil(EntityManager entityManager, CriteriaBuilder criteriaBuilder, Class<TEntity> entityClass) {
        this.entityManager = entityManager;
        this.criteriaBuilder = criteriaBuilder;
        this.entityClass = entityClass;

        Optional<Field> firstId = Arrays.stream(this.entityClass.getDeclaredFields())
                .filter(x -> x.getDeclaredAnnotation(Id.class) != null)
                .findFirst();
        firstId.ifPresent(column -> columnName = column.getName());

        BytecodeReadingParanamer asm = new BytecodeReadingParanamer();
        ATTRIBUTED = new ArrayList<>();
        Arrays.stream(this.entityClass.getDeclaredConstructors()).forEach(constructor -> {
            if (constructor.getDeclaredAnnotation(CommonConstructor.class) != null) {
                ATTRIBUTED.addAll(Arrays.asList(asm.lookupParameterNames(constructor)));
            }
        });
    }

    protected Page<TEntity> findAllWithFilters(PageModel page, TSearchCriteria searchCriteria) {
        page = reviewPage(page);
        Map<String, Object> queryAndCount = createQuery(page, searchCriteria);
        TypedQuery<TEntity> typedQuery = (TypedQuery<TEntity>) queryAndCount.get("query");
        typedQuery.setFirstResult(page.getPageNumber() * page.getPageSize());
        typedQuery.setMaxResults(page.getPageSize());
        return new PageImpl<>(typedQuery.getResultList(), getPageable(page), (Long) queryAndCount.get("count"));
    }

    protected List<TEntity> findAllWithFiltersList(PageModel page, TSearchCriteria searchCriteria) {
        page = reviewPage(page);
        Map<String, Object> queryAndCount = createQuery(page, searchCriteria);
        TypedQuery<TEntity> typedQuery = (TypedQuery<TEntity>) queryAndCount.get("query");
        return typedQuery.getResultList();
    }

    private Map<String, Object> createQuery(PageModel pageModel, TSearchCriteria searchCriteria) {
        HashMap<String, Object> mapResult = new HashMap<>();
        CriteriaQuery<TEntity> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
        Root<TEntity> root = criteriaQuery.from(this.entityClass);

        //Indicate Fields tp be fetched
        List<Selection<?>> selections = new ArrayList<>();
        for (String item: ATTRIBUTED) {
            selections.add(root.get(item));
        }

        criteriaQuery.multiselect(selections);

        // Define predicated to filter ou r result
        Predicate predicate = getPredicate(searchCriteria, root);
        criteriaQuery.where(predicate);

        setOrder(pageModel, criteriaQuery, root);

        mapResult.put("query", entityManager.createQuery(criteriaQuery));
        mapResult.put("count", getCount(predicate));
        return mapResult;
    }

    private Predicate getPredicate(TSearchCriteria searchCriteria, Root<TEntity> root) {
        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = searchCriteria != null ? searchCriteria.getClass().getDeclaredFields() : new Field[0];
        for (Field f : fields) {
            f.setAccessible(true);
            Class<?> fieldType = f.getType();
            Object v = null;
            try {
                v = f.get(searchCriteria);
            } catch (IllegalAccessException e) {
                LOGGER.warning(ExceptionUtils.getStackTrace(e));
            }

            if (v != null) {
                // Single String Filter
                if (fieldType == String.class) {
                    if (!v.equals("")) {
                        predicates.add(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get(f.getName())),
                                        "%" + v.toString().toLowerCase() + "%")
                        );
                    }
                }

                // Multiple String filter
                if (fieldType == String[].class) {
                    String[] options = (String[]) v;
                    if (options.length > 0) {
                        List<String> values = Arrays.asList(options);
                        Predicate predicate = root.get(f.getName()).in(values);
                        predicates.add(predicate);
                    }
                }

                // Range Integer filter
                if (fieldType == Integer[].class) {
                    Integer[] quantity = (Integer[]) v;
                    if (quantity[1] == null) {
                        quantity[1] = quantity[0];
                    }
                    if (quantity[0] >= 0 && quantity[1] >= 0) {
                        Path<Integer> setQuantity = root.get(f.getName());
                        predicates.add(criteriaBuilder.between(setQuantity, quantity[0], quantity[1]));
                    }
                }

                if (fieldType == Integer.class) {
                    Integer value = (Integer) v;
                    Path<Integer> setQuantity = root.get(f.getName());
                    predicates.add(criteriaBuilder.equal(setQuantity, value));
                }

                // Range Double filter
                if (fieldType == Double[].class) {
                    Double[] quantity = (Double[]) v;
                    if (quantity[1] == null) {
                        quantity[1] = quantity[0];
                    }
                    if (quantity[0] >= 0 && quantity[1] >= 0) {
                        Path<Double> setQuantity = root.get(f.getName());
                        predicates.add(criteriaBuilder.between(setQuantity, quantity[0], quantity[1]));
                    }
                }

                // Range Float filter
                if (fieldType == Float[].class) {
                    Float[] quantity = (Float[]) v;
                    if (quantity[1] == null) {
                        quantity[1] = quantity[0];
                    }
                    if (quantity[0] >= 0 && quantity[1] >= 0) {
                        Path<Float> setQuantity = root.get(f.getName());
                        predicates.add(criteriaBuilder.between(setQuantity, quantity[0], quantity[1]));
                    }
                }

                // Range Dates filter
                if (fieldType == Date[].class) {
                    Date[] dates = (Date[]) v;
                    if (dates[1] == null) {
                        dates[1] = dates[0];
                    }

                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.HOUR_OF_DAY, 23);
                    cal.set(Calendar.MINUTE, 59);
                    cal.set(Calendar.SECOND, 59);
                    cal.set(Calendar.MILLISECOND, 999);
                    dates[1] = cal.getTime();

                    Path<Date> rangeDates = root.get(f.getName());
                    predicates.add(criteriaBuilder.between(rangeDates, dates[0], dates[1]));
                }

                // Range Boolean Filter
                if (fieldType == Boolean.class) {
                    if (v.equals(true)) {
                        predicates.add(criteriaBuilder.isTrue(root.get(f.getName())));
                    }
                    if (v.equals(false)) {
                        predicates.add(criteriaBuilder.isFalse(root.get(f.getName())));
                    }
                }
            }

        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(PageModel pageModel, CriteriaQuery<TEntity> criteriaQuery, Root<TEntity> root) {
        Expression<?> idExpression = root.get(columnName);
        if (pageModel.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(pageModel.getSortBy())), criteriaBuilder.asc(idExpression));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(pageModel.getSortBy())), criteriaBuilder.desc(idExpression));
        }
    }

    private Pageable getPageable(PageModel pageModel) {
        Sort sort = Sort.by(pageModel.getSortDirection(), pageModel.getSortBy());
        return PageRequest.of(pageModel.getPageNumber(), pageModel.getPageSize(), sort);
    }

    private long getCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<?> countRoot = countQuery.from(entityClass);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private PageModel reviewPage(PageModel page) {
        if (page != null)
            page.setEntityClass(this.entityClass);
        else
            page = new PageModel(this.entityClass);
        return  page;
    }
}
