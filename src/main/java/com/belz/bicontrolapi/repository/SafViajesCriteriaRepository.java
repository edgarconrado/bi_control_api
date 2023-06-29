package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafViajes;
import com.belz.bicontrolapi.filterModel.safViajes.SafViajesPage;
import com.belz.bicontrolapi.filterModel.safViajes.SafViajesSearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class SafViajesCriteriaRepository {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafViajesCriteriaRepository.class));
    String classname = String.valueOf(SafViajesCriteriaRepository.class);
    private static final Field[] attribustes = SafViajes.class.getDeclaredFields();
    private static final List<String> ATTRIBUTESLIST = new ArrayList<>();
    static {
        for (int i = 0; i < attribustes.length; i++){
            ATTRIBUTESLIST.add(attribustes[i].getName());
        }
    }

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public SafViajesCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<SafViajes> findAllWithFilters(SafViajesPage safViajesPage, SafViajesSearchCriteria safViajesSearchCriteria) {
        String methodName = "findAllWithFilters";
        CriteriaQuery<SafViajes> criteriaQuery = criteriaBuilder.createQuery(SafViajes.class);
        Root<SafViajes> safViajesRoot = criteriaQuery.from(SafViajes.class);
        List<Selection<?>> inputs = new ArrayList<Selection<?>>();
        TypedQuery<SafViajes> typedQuery = null;
        Pageable pageable = null;
        long itemCount = 0;
        try {
            for (String select: ATTRIBUTESLIST) {
                inputs.add(safViajesRoot.get(select));
            }

            criteriaQuery.multiselect(inputs);

            // define predicate to filter out result
            Predicate predicate = getPredicate(safViajesSearchCriteria, safViajesRoot);
            criteriaQuery.where(predicate);

            // sorting
            setOrder(safViajesPage, criteriaQuery, safViajesRoot);

            typedQuery = entityManager.createQuery(criteriaQuery);
            typedQuery.setFirstResult(safViajesPage.getPageNumber() * safViajesPage.getPageSize());
            typedQuery.setMaxResults(safViajesPage.getPageSize());
            pageable = getPageable(safViajesPage);

            // get numbers of items
            itemCount = getCount(predicate);

            return new PageImpl<>(typedQuery.getResultList(), pageable, itemCount);

        } catch (Exception e) {
            logger.info(classname + ":" + methodName + "-" + e);
        }

        List<SafViajes> emptyList = Collections.<SafViajes>emptyList();
        pageable = getPageable(safViajesPage);
        return new PageImpl<SafViajes>(emptyList, pageable, 0);

    }

    private long getCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<SafViajes> countRoot = countQuery.from(SafViajes.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(SafViajesPage safViajesPage) {
        Sort sort = Sort.by(safViajesPage.getSortDirection(), safViajesPage.getSortBy());
        return PageRequest.of(safViajesPage.getPageNumber(), safViajesPage.getPageSize(), sort);
    }

    private void setOrder(SafViajesPage safViajesPage, CriteriaQuery<SafViajes> criteriaQuery, Root<SafViajes> safViajesRoot) {
        if (safViajesPage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(safViajesRoot.get(safViajesPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(safViajesRoot.get(safViajesPage.getSortBy())));
        }
    }

    private Predicate getPredicate(SafViajesSearchCriteria searchCriteria, Root<SafViajes> root) {
        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = searchCriteria.getClass().getDeclaredFields();

        for ( Field f : fields ) {
            f.setAccessible(true);
            Class<?> fieldType = f.getType();
            Object v = null;
            try {
                v = f.get(searchCriteria);
            } catch (IllegalAccessException e) {
                logger.warning(ExceptionUtils.getStackTrace(e));
            }

            if ( v != null) {
                /// Single String filter
                //Single String filter
                if (fieldType == String.class) {
                    if (!v.equals("")) {
                        predicates.add(
                                criteriaBuilder.like(criteriaBuilder.lower(root.get(f.getName())),
                                        "%" + v.toString().toLowerCase() + "%")
                        );
                    }
                }
                // Multiple string filter
                if (fieldType == String[].class) {
                    String[] options = (String[]) v;
                    if (options.length > 0) {
                        List<String> values = Arrays.asList(options);
                        Predicate predicate = root.get(f.getName()).in(values);
                        predicates.add(predicate);
                    }
                }
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    public List<SafViajes> findViajesToDownload(SafViajesPage page, SafViajesSearchCriteria searchCriteria) {
        String methodName = "findViajesToDownload";
        List<Selection<?>> inputs = new ArrayList<>();
        TypedQuery<SafViajes> typedQuery;
        try {
            CriteriaQuery<SafViajes> criteriaQuery = criteriaBuilder.createQuery(SafViajes.class);
            Root<SafViajes> viewRoot = criteriaQuery.from(SafViajes.class);

            // Indicate fields to be fetched
            for (String select : ATTRIBUTESLIST) {
                inputs.add(viewRoot.get(select));
            }
            criteriaQuery.multiselect(inputs);

            // Define predicate to filter our result
            Predicate predicate = getPredicate(searchCriteria, viewRoot);
            criteriaQuery.where(predicate);

            // sorting
            setOrder(page, criteriaQuery, viewRoot);
            typedQuery = entityManager.createQuery(criteriaQuery);

            return typedQuery.getResultList();
        } catch (Exception e) {
            logger.info("Exception in " + classname + ":" + methodName + " - " + e);
        }

        return new ArrayList<SafViajes>();
    }


}
