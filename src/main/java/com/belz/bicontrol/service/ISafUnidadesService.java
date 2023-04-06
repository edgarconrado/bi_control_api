package com.belz.bicontrol.service;

import com.belz.bicontrol.entity.SafUnidades;
import com.belz.bicontrol.filterModel.SafUnidadesFilter;
import com.belz.bicontrol.filterModel.SafUnidadesPage;
import com.belz.bicontrol.filterModel.SafUnidadesSearchCriteria;
import org.springframework.data.domain.Page;

public interface ISafUnidadesService {

    Page<SafUnidades> getUnidades(SafUnidadesPage unidadesPage, SafUnidadesSearchCriteria unidadesSearchCriteria);

    Page<SafUnidades> getUnidadesPage(SafUnidadesFilter unidadesFilter);

}
