package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.entity.SafBitacora;
import com.belz.bicontrolapi.filterModel.safBitacora.SafBitacoraPage;
import com.belz.bicontrolapi.filterModel.safBitacora.SafBitacoraSearchCriteria;
import com.belz.bicontrolapi.repository.SafBitacoraCriteriaRepository;
import com.belz.bicontrolapi.service.ISafBitacoraServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SafBitacoraService implements ISafBitacoraServie {

    @Autowired
    SafBitacoraCriteriaRepository safBitacoraCriteriaRepository;

    @Override
    public Page<SafBitacora> getBitacora(SafBitacoraPage page, SafBitacoraSearchCriteria searchCriteria) {
        return safBitacoraCriteriaRepository.findAllWithFilters(page, searchCriteria);
    }
}
