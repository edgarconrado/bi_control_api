package com.belz.bicontrolapi.repository.impl;

import com.belz.bicontrolapi.entity.SafViajes;
import com.belz.bicontrolapi.filterModel.SafViajesSearchCriteria;
import com.belz.bicontrolapi.repository.CommonViewRepository;
import com.belz.bicontrolapi.repository.CommonViewUtil;
import com.belz.bicontrolapi.util.PageModel;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SafViajesRepositoryImpl extends CommonViewUtil<SafViajes, SafViajesSearchCriteria> implements CommonViewRepository<SafViajes, SafViajesSearchCriteria> {
    protected SafViajesRepositoryImpl(EntityManager entityManager) {
        super(entityManager, entityManager.getCriteriaBuilder(), SafViajes.class);
    }

    @Override
    public Page<SafViajes> findAllWithFilters(PageModel page, SafViajesSearchCriteria searchCriteria) {
        return super.findAllWithFilters(page, searchCriteria);
    }

    @Override
    public List<SafViajes> findAllWithFiltersList(PageModel page, SafViajesSearchCriteria searchCriteria) {
        return super.findAllWithFiltersList(page, searchCriteria);
    }
}
