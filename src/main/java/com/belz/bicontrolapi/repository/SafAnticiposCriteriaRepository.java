package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafAnticipos;
import com.belz.bicontrolapi.filterModel.safAnticipos.SafAnticiposPage;
import com.belz.bicontrolapi.filterModel.safAnticipos.SafAnticiposSearchCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class SafAnticiposCriteriaRepository {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafAnticiposCriteriaRepository.class));
    String classname = String.valueOf(SafAnticiposCriteriaRepository.class);
    private static final Field[] attributes = SafAnticipos.class.getDeclaredFields();
    private static final List<String> ATTRIBUTESLIST = new ArrayList<>();
    static {
        for (int i = 0; i < attributes.length; i++){
            ATTRIBUTESLIST.add(attributes[i].getName());
        }
    }

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public SafAnticiposCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<SafAnticipos> findAllWithFilters(SafAnticiposPage safAnticiposPage, SafAnticiposSearchCriteria safAnticiposSearchCriteria) {
        String methodName = "findAllWithFilters";
        CriteriaQuery<SafAnticipos> criteriaQuery = criteriaBuilder.createQuery(SafAnticipos.class);
        Root<SafAnticipos> safAnticiposRoot = criteriaQuery.from(SafAnticipos.class);
        List<Selection<?>> inputs = new ArrayList<>();
        TypedQuery<SafAnticipos> typedQuery = null;
        Pageable pageable = null;
        long itemCount = 0;
        try {
            for (String select : ATTRIBUTESLIST) {
                inputs.add(safAnticiposRoot.get(select));
            }

            criteriaQuery.multiselect(inputs);

            //define predicate to filter out result
            Predicate predicate = getPredicate(safAnticiposSearchCriteria, safAnticiposRoot);
            criteriaQuery.where(predicate);

            // sorting
            setOrder(safAnticiposPage, criteriaQuery, safAnticiposRoot);

            typedQuery = entityManager.createQuery(criteriaQuery);
            typedQuery.setFirstResult(safAnticiposPage.getPageNumber() * safAnticiposPage.getPageSize());
            typedQuery.setMaxResults(safAnticiposPage.getPageSize());
            pageable = getPageable(safAnticiposPage);
            // get numbers of items
            itemCount = getCount(predicate);

            return new PageImpl<>(typedQuery.getResultList(), pageable, itemCount);

        } catch (Exception e) {
            logger.info(classname + ":" + methodName + "-" + e);
        }

        List<SafAnticipos> emptyList = Collections.<SafAnticipos>emptyList();
        pageable = getPageable(safAnticiposPage);
        return new PageImpl<SafAnticipos>(emptyList, pageable, 0);

    }

    private long getCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<SafAnticipos> countRoot = countQuery.from(SafAnticipos.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(SafAnticiposPage safAnticiposPage) {
        Sort sort = Sort.by(safAnticiposPage.getSortDirection(), safAnticiposPage.getSortBy());
        return PageRequest.of(safAnticiposPage.getPageNumber(), safAnticiposPage.getPageSize(), sort);
    }

    private void setOrder(SafAnticiposPage safAnticiposPage, CriteriaQuery<SafAnticipos> criteriaQuery, Root<SafAnticipos> safAnticiposRoot) {
        if (safAnticiposPage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(safAnticiposRoot.get(safAnticiposPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(safAnticiposRoot.get(safAnticiposPage.getSortBy())));
        }
    }

    private Predicate getPredicate(SafAnticiposSearchCriteria searchCriteria, Root< SafAnticipos > root) {
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

    public List<SafAnticipos> findAnticiposToDownload(SafAnticiposPage page, SafAnticiposSearchCriteria searchCriteria) {
        String methodName = "findAnticiposToDownload";
        List<Selection<?>> inputs = new ArrayList<>();
        TypedQuery<SafAnticipos> typedQuery;
        try {
            CriteriaQuery<SafAnticipos> criteriaQuery = criteriaBuilder.createQuery(SafAnticipos.class);
            Root<SafAnticipos> viewRoot = criteriaQuery.from(SafAnticipos.class);

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

        return new ArrayList<SafAnticipos>();
    }

}
