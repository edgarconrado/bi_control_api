package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.entity.SafUnidades;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesPage;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesSearchCriteria;
import org.springframework.data.domain.Page;

public interface ISafUnidadesService {

    Page<SafUnidades> getUnidades(SafUnidadesPage safUnidadesPage, SafUnidadesSearchCriteria safUnidadesSearchCriteria);

}
