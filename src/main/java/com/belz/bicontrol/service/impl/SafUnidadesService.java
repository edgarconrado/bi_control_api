package com.belz.bicontrol.service.impl;

import com.belz.bicontrol.entity.SafUnidades;
import com.belz.bicontrol.filterModel.SafUnidadesFilter;
import com.belz.bicontrol.filterModel.SafUnidadesPage;
import com.belz.bicontrol.filterModel.SafUnidadesSearchCriteria;
import com.belz.bicontrol.repository.SafUnidadesCriteriaRepository;
import com.belz.bicontrol.repository.SafUnidadesRepository;
import com.belz.bicontrol.service.ISafUnidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SafUnidadesService implements ISafUnidadesService {


    @Autowired
    SafUnidadesCriteriaRepository unidadesCriteriaRepository;

    @Autowired
    SafUnidadesRepository unidadesRepository;

    @Override
    public Page<SafUnidades> getUnidades(SafUnidadesPage unidadesPage, SafUnidadesSearchCriteria unidadesSearchCriteria) {
        return unidadesCriteriaRepository.findAllWithFilter(unidadesPage, unidadesSearchCriteria);
    }

    @Override
    public Page<SafUnidades> getUnidadesPage(SafUnidadesFilter unidadesFilter) {
        Pageable pageable = PageRequest.of(unidadesFilter.getUnidadesPage().getPageNumber(), unidadesFilter.getUnidadesPage().getPageSize());
        return unidadesRepository.findAllPagination(pageable);
    }
}
