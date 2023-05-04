package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafUnidades;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesPage;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesSearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

@Repository
@RequiredArgsConstructor
public class SafUniadesCriteriaRepository {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafUniadesCriteriaRepository.class));
    String classname = String.valueOf(SafUniadesCriteriaRepository.class);
    private static final Field[] attributes = SafUnidades.class.getDeclaredFields();
    private static final List<String> ATTRIBUTESLIST = new ArrayList<>();
    static {
        for (int i = 0; i < attributes.length; i++){
            ATTRIBUTESLIST.add(attributes[i].getName());
        }
    }
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public Page<SafUnidades> findAllWithFilters(SafUnidadesPage safUnidadesPage, SafUnidadesSearchCriteria safUnidadesSearchCriteria) {

        String methodName = "findAllWithFilters";
        CriteriaQuery<SafUnidades> criteriaQuery = criteriaBuilder.createQuery(SafUnidades.class);
        Root<SafUnidades> safUnidadesRoot = criteriaQuery.from(SafUnidades.class);
        List<Selection<?>> inputs = new ArrayList<Selection<?>>();
        TypedQuery<SafUnidades> typedQuery = null;
        Pageable pageable = null;
        long itemCount = 0;
        try {
            for (String select: ATTRIBUTESLIST) {
                inputs.add(safUnidadesRoot.get(select));
            }

            criteriaQuery.multiselect(inputs);

            // define predicate to filer our result
            Predicate predicate = getPredicate(safUnidadesSearchCriteria, safUnidadesRoot);
            criteriaQuery.where(predicate);

            //sorting
            setOrder(safUnidadesPage, criteriaQuery, safUnidadesRoot);

            // create query and get results
            typedQuery = entityManager.createQuery(criteriaQuery);
            typedQuery.setFirstResult((safUnidadesPage.getPageNumber() * safUnidadesPage.getPageSize()));
            typedQuery.setMaxResults(safUnidadesPage.getPageSize());
            pageable = getPageable(safUnidadesPage);

            // get numbers of items
            itemCount = getCount(predicate);

            return new PageImpl<>(typedQuery.getResultList(), pageable, itemCount);
        } catch (Exception e) {
            logger.info( classname + ":" + methodName + " - " + e);
        }

        List<SafUnidades> emptyList = Collections.<SafUnidades>emptyList();
        pageable =  getPageable(safUnidadesPage);
        return new PageImpl<SafUnidades>(emptyList, pageable, 0);

    }

    private long getCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<SafUnidades> countRoot = countQuery.from(SafUnidades.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(SafUnidadesPage safUnidadesPage) {
        Sort sort = Sort.by(safUnidadesPage.getSortDirection(), safUnidadesPage.getSortBy());
        return PageRequest.of(safUnidadesPage.getPageNumber(), safUnidadesPage.getPageSize(), sort);
    }

    private void setOrder(SafUnidadesPage safUnidadesPage, CriteriaQuery<SafUnidades> criteriaQuery, Root<SafUnidades> safUnidadesRoot) {
        if (safUnidadesPage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(safUnidadesRoot.get(safUnidadesPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(safUnidadesRoot.get(safUnidadesPage.getSortBy())));
        }
    }


    private Predicate getPredicate(SafUnidadesSearchCriteria searchCriteria, Root<SafUnidades> root) {

        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = searchCriteria.getClass().getDeclaredFields();

        for ( Field f : fields) {
            f.setAccessible(true);
            Class<?> fieldType = f.getType();
            Object v = null;
            try {
                v = f.get(searchCriteria);
            } catch (IllegalAccessException e) {
                logger.warning(ExceptionUtils.getStackTrace(e));
            }
            if (v != null) {
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

    public List<SafUnidades> findUnidadesToDownload(SafUnidadesPage page, SafUnidadesSearchCriteria searchCriteria) {
        String methodName = "findUnidadesToDownload";
        List<Selection<?>> inputs = new ArrayList<>();
        TypedQuery<SafUnidades> typedQuery;
        try {
            CriteriaQuery<SafUnidades> criteriaQuery = criteriaBuilder.createQuery(SafUnidades.class);
            Root<SafUnidades> viewRoot = criteriaQuery.from(SafUnidades.class);

            // Indicate fields to be fetched
            for (String select : ATTRIBUTESLIST) {
                inputs.add(viewRoot.get(select));
            }
            criteriaQuery.multiselect(inputs);

            // Define predicate to filter out result
            Predicate predicate = getPredicate(searchCriteria, viewRoot);
            criteriaQuery.where(predicate);

            // sorting
            setOrder(page, criteriaQuery, viewRoot);
            typedQuery = entityManager.createQuery(criteriaQuery);

            return typedQuery.getResultList();
        } catch (Exception e) {
            logger.info("Exception in " + classname + ":" + methodName + " - " + e);
        }

        return new ArrayList<SafUnidades>();
    }

}
