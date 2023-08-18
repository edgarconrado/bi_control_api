package com.belz.bicontrolapi.repository.impl;

import com.belz.bicontrolapi.entity.SafAnticipos;
import com.belz.bicontrolapi.filterModel.SafAnticiposSearchCriteria;
import com.belz.bicontrolapi.repository.CommonViewRepository;
import com.belz.bicontrolapi.repository.CommonViewUtil;
import com.belz.bicontrolapi.util.PageModel;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SafAnticiposRepositoryImpl extends CommonViewUtil<SafAnticipos, SafAnticiposSearchCriteria> implements CommonViewRepository<SafAnticipos, SafAnticiposSearchCriteria> {
    protected SafAnticiposRepositoryImpl(EntityManager entityManager) {
        super(entityManager, entityManager.getCriteriaBuilder(), SafAnticipos.class);
    }
    @Override
    public Page<SafAnticipos> findAllWithFilters(PageModel page, SafAnticiposSearchCriteria searchCriteria) {
        return super.findAllWithFilters(page, searchCriteria);
    }

    @Override
    public List<SafAnticipos> findAllWithFiltersList(PageModel page, SafAnticiposSearchCriteria searchCriteria) {
        return super.findAllWithFiltersList(page, searchCriteria);
    }
}
