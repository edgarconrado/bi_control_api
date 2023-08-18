package com.belz.bicontrolapi.repository.impl;

import com.belz.bicontrolapi.entity.SafBitacora;
import com.belz.bicontrolapi.filterModel.SafBitacoraSearchCriteria;
import com.belz.bicontrolapi.repository.CommonViewRepository;
import com.belz.bicontrolapi.repository.CommonViewUtil;
import com.belz.bicontrolapi.util.PageModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SafBitacoraRepositoryImpl extends CommonViewUtil<SafBitacora, SafBitacoraSearchCriteria> implements CommonViewRepository<SafBitacora, SafBitacoraSearchCriteria> {
    protected SafBitacoraRepositoryImpl(EntityManager entityManager) {
        super(entityManager, entityManager.getCriteriaBuilder(), SafBitacora.class);
    }

    @Override
    public Page<SafBitacora> findAllWithFilters(PageModel page, SafBitacoraSearchCriteria searchCriteria) {
        return super.findAllWithFilters(page, searchCriteria);
    }

    @Override
    public List<SafBitacora> findAllWithFiltersList(PageModel page, SafBitacoraSearchCriteria searchCriteria) {
        return super.findAllWithFiltersList(page, searchCriteria);
    }
}
