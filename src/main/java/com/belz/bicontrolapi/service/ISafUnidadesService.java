package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.entity.SafUnidades;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesPage;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesSearchCriteria;
import com.belz.bicontrolapi.repository.SafUnidadesRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface ISafUnidadesService {

    Page<SafUnidades> getUnidades(SafUnidadesPage safUnidadesPage, SafUnidadesSearchCriteria safUnidadesSearchCriteria);

}
