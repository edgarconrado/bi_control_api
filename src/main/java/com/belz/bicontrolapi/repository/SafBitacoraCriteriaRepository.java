package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafBitacora;
import com.belz.bicontrolapi.filterModel.safBitacora.SafBitacoraPage;
import com.belz.bicontrolapi.filterModel.safBitacora.SafBitacoraSearchCriteria;
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
public class SafBitacoraCriteriaRepository {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafBitacoraCriteriaRepository.class));
    String classname = String.valueOf(SafBitacoraCriteriaRepository.class);
    private static final Field[] attributes = SafBitacora.class.getDeclaredFields();
    private static final List<String> ATTRIBUTESLIST = new ArrayList<>();
    static {
        for (int i = 0; i < attributes.length; i++){
            ATTRIBUTESLIST.add(attributes[i].getName());
        }
    }

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public SafBitacoraCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<SafBitacora> findAllWithFilters(SafBitacoraPage safBitacoraPage, SafBitacoraSearchCriteria safBitacoraSearchCriteria) {
        String methodName = "findAllWithFilters";
        CriteriaQuery<SafBitacora> criteriaQuery = criteriaBuilder.createQuery(SafBitacora.class);
        Root<SafBitacora> safBitacoraRoot = criteriaQuery.from(SafBitacora.class);
        List<Selection<?>> inputs = new ArrayList<Selection<?>>();
        TypedQuery<SafBitacora> typedQuery = null;
        Pageable pageable = null;
        long itemCount = 0;
        try {
            for (String select: ATTRIBUTESLIST) {
                inputs.add(safBitacoraRoot.get(select));
            }

            criteriaQuery.multiselect(inputs);

            // define predicate to filter out result
            Predicate predicate = getPredicate(safBitacoraSearchCriteria, safBitacoraRoot);
            criteriaQuery.where(predicate);

            // sorting
            setOrder(safBitacoraPage, criteriaQuery, safBitacoraRoot);

            typedQuery = entityManager.createQuery(criteriaQuery);
            typedQuery.setFirstResult(safBitacoraPage.getPageNumber() * safBitacoraPage.getPageSize());
            typedQuery.setMaxResults(safBitacoraPage.getPageSize());
            pageable = getPageable(safBitacoraPage);

            // get numbers of items
            itemCount = getCount(predicate);

            return new PageImpl<>(typedQuery.getResultList(), pageable, itemCount);

        } catch (Exception e) {
            logger.info(classname + ":" + methodName + "-" + e);
        }

        List<SafBitacora> emptyList = Collections.<SafBitacora>emptyList();
        pageable = getPageable(safBitacoraPage);
        return new PageImpl<SafBitacora>(emptyList, pageable, 0);

    }
    private long getCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<SafBitacora> countRoot = countQuery.from(SafBitacora.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Pageable getPageable(SafBitacoraPage safBitacoraPage) {
        Sort sort = Sort.by(safBitacoraPage.getSortDirection(), safBitacoraPage.getSortBy());
        return PageRequest.of(safBitacoraPage.getPageNumber(), safBitacoraPage.getPageSize(), sort);
    }

    private void setOrder(SafBitacoraPage safBitacoraPage, CriteriaQuery<SafBitacora> criteriaQuery, Root<SafBitacora> safBitacoraRoot) {
        if (safBitacoraPage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(safBitacoraRoot.get(safBitacoraPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(safBitacoraRoot.get(safBitacoraPage.getSortBy())));
        }
    }

    private Predicate getPredicate(SafBitacoraSearchCriteria searchCriteria, Root<SafBitacora> root) {
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

    public List<SafBitacora> findBitacoraToDownload(SafBitacoraPage page, SafBitacoraSearchCriteria searchCriteria) {
        String methodName = "findBitacoraToDownload";
        List<Selection<?>> inputs = new ArrayList<>();
        TypedQuery<SafBitacora> typedQuery;
        try {
            CriteriaQuery<SafBitacora> criteriaQuery = criteriaBuilder.createQuery(SafBitacora.class);
            Root<SafBitacora> viewRoot = criteriaQuery.from(SafBitacora.class);

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

        return new ArrayList<SafBitacora>();
    }
}
