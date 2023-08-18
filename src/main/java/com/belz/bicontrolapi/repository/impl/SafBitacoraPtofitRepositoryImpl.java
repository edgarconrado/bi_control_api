package com.belz.bicontrolapi.repository.impl;

import com.belz.bicontrolapi.entity.SafBitacoraPtofit;
import com.belz.bicontrolapi.filterModel.SafBitacoraPtofitSearchCriteria;
import com.belz.bicontrolapi.repository.CommonViewRepository;
import com.belz.bicontrolapi.repository.CommonViewUtil;
import com.belz.bicontrolapi.util.PageModel;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SafBitacoraPtofitRepositoryImpl extends CommonViewUtil<SafBitacoraPtofit, SafBitacoraPtofitSearchCriteria> implements CommonViewRepository<SafBitacoraPtofit, SafBitacoraPtofitSearchCriteria> {
    protected SafBitacoraPtofitRepositoryImpl(EntityManager entityManager) {
        super(entityManager, entityManager.getCriteriaBuilder(), SafBitacoraPtofit.class);
    }

    @Override
    public Page<SafBitacoraPtofit> findAllWithFilters(PageModel page, SafBitacoraPtofitSearchCriteria searchCriteria) {
        return super.findAllWithFilters(page, searchCriteria);
    }

    @Override
    public List<SafBitacoraPtofit> findAllWithFiltersList(PageModel page, SafBitacoraPtofitSearchCriteria searchCriteria) {
        return super.findAllWithFiltersList(page, searchCriteria);
    }
}
