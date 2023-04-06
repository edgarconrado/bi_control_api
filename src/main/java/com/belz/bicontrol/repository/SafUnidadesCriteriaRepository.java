package com.belz.bicontrol.repository;

import com.belz.bicontrol.entity.SafUnidades;
import com.belz.bicontrol.filterModel.SafUnidadesPage;
import com.belz.bicontrol.filterModel.SafUnidadesSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class SafUnidadesCriteriaRepository {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafUnidadesCriteriaRepository.class));
    String classname = String.valueOf(SafUnidadesCriteriaRepository.class);
    private static final Field[] attributes = SafUnidades.class.getDeclaredFields();
    private static final List<String> ATTRIBUTESLIST = new ArrayList<>();
    static {
        for (Field attribute : attributes) {
            ATTRIBUTESLIST.add(attribute.getName());
        }
    }

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public SafUnidadesCriteriaRepository(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
        this.entityManager = entityManager;
        this.criteriaBuilder = criteriaBuilder;
    }

    public Page<SafUnidades> findAllWithFilter(SafUnidadesPage unidadesPage, SafUnidadesSearchCriteria unidadesSearchCriteria){
        String methodName = "findAllWithFilter";
        CriteriaQuery<SafUnidades> criteriaQuery = criteriaBuilder.createQuery(SafUnidades.class);
        Root<SafUnidades> unidadesViewRoot = criteriaQuery.from(SafUnidades.class);
        List<Selection<?>> inputs = new ArrayList<Selection<?>>();
        TypedQuery<SafUnidades> typedQuery = null;
        Pageable pageable = null;
        long itemsCount = 0;
        try {
            for(String select: ATTRIBUTESLIST){
                inputs.add(unidadesViewRoot.get(select));
            }
            criteriaQuery.multiselect(inputs);

            //Define Predicates to filter out result
            Predicate predicate = getPredicate(unidadesSearchCriteria, unidadesViewRoot);
            criteriaQuery.where(predicate);

            //sorting
            setOrder(unidadesPage, criteriaQuery, unidadesViewRoot);
            typedQuery = entityManager.createQuery(criteriaQuery);
            typedQuery.setFirstResult(unidadesPage.getPageNumber() * unidadesPage.getPageSize());
            typedQuery.setMaxResults(unidadesPage.getPageSize());
            pageable = getPageable(unidadesPage);
            itemsCount = getCount(predicate);
            return new PageImpl<>(typedQuery.getResultList(), pageable, itemsCount);
        } catch ( Exception e) {
            logger.info(classname+":"+methodName+" - " + e);
        }

        List<SafUnidades> emptyList = Collections.<SafUnidades>emptyList();
        pageable = getPageable(unidadesPage);
        return new PageImpl<SafUnidades>(emptyList, pageable,0);
    }

    public List<SafUnidades> findBrokersToDownload(SafUnidadesPage page, SafUnidadesSearchCriteria searchCriteria){
        String methodName = "findBrokersToDownload";
        List<Selection<?>> inputs = new ArrayList<Selection<?>>();
        TypedQuery<SafUnidades> typedQuery;
        try{
            CriteriaQuery<SafUnidades> criteriaQuery = criteriaBuilder.createQuery(SafUnidades.class);
            Root<SafUnidades> viewRoot = criteriaQuery.from(SafUnidades.class);
            //check param
            //Indicate fields to be fetched
            for (String select : ATTRIBUTESLIST) {
                inputs.add(viewRoot.get(select));
            }
            criteriaQuery.multiselect(inputs);
            //Define predicates to filter our result
            Predicate predicate = getPredicate(searchCriteria, viewRoot);
            criteriaQuery.where(predicate);
            //sorting
            setOrder(page,criteriaQuery,viewRoot);
            typedQuery = entityManager.createQuery(criteriaQuery);
            return typedQuery.getResultList();
        }
        catch (Exception e){
            logger.info("Exception in "+classname+":"+methodName+" - " + e);
        }
        return new ArrayList<SafUnidades>();
    }

    private void setOrder(SafUnidadesPage unidadesPage, CriteriaQuery<SafUnidades> criteriaQuery, Root<SafUnidades> timeRoot){
            if (unidadesPage.getSortDirection().equals(Sort.Direction.ASC)){
                criteriaQuery.orderBy(criteriaBuilder.asc(timeRoot.get(unidadesPage.getSortBy())));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(timeRoot.get(unidadesPage.getSortBy())));
            }
    }

    private Pageable getPageable(SafUnidadesPage unidadesPage) {
        Sort sort = Sort.by(unidadesPage.getSortDirection(), unidadesPage.getSortBy());
        return PageRequest.of(unidadesPage.getPageNumber(), unidadesPage.getPageSize(), sort);
    }

    private long getCount(Predicate predicate){
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery((Long.class));
        Root<SafUnidades> countRoot = countQuery.from(SafUnidades.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    private Predicate getPredicate(SafUnidadesSearchCriteria searchCriteria, Root<SafUnidades> itemRoot){
        String methodName = "getPredicate";
        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = searchCriteria.getClass().getDeclaredFields();
        try{
            for(Field f : fields){
                Class<?> fieldType = f.getType();
                f.setAccessible(true);
                Object v = f.get(searchCriteria);
                if(v!=null){
                    if(fieldType == Date[].class){
                        Path<Date> setDates = itemRoot.get(f.getName());
                        Date[] dates = (Date[]) v;
                        if(dates[1]==null){
                            dates[1] = dates[0];
                        }
                        Predicate predicate = criteriaBuilder.between(setDates,dates[0],dates[1]);
                        predicates.add(predicate);
                    }

                    else if((f.getName().equals("brokers"))){
                        String[] broker = (String[]) v;
                        if(broker.length>0) {
                            List<String> values = new ArrayList<>();
                            for(int i=0;i<broker.length;i++){
                                if(!broker[i].toString().equals("")){
                                    values.add(broker[i]);
                                }
                            }
                            Predicate predicate = itemRoot.get(f.getName()).in(values);
                            predicates.add(predicate);
                        }
                    }

                    else if(fieldType == String.class && !v.equals("")){
                        predicates.add(
                                criteriaBuilder.like(criteriaBuilder.lower(itemRoot.get(f.getName())),
                                        "%" + v.toString().toLowerCase() + "%")
                        );
                    }
                    else if (fieldType == Integer.class && (Integer)v != 0){
                        Predicate predicate = criteriaBuilder.equal(itemRoot.get(f.getName()),v);
                        predicates.add(predicate);
                    }

                }
            }
        }
        catch (Exception e){
            logger.info(classname+":"+methodName+" - " + e);
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
