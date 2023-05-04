package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.entity.SafUnidades;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesPage;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesSearchCriteria;
import com.belz.bicontrolapi.repository.SafUniadesCriteriaRepository;
import com.belz.bicontrolapi.repository.SafUnidadesRepository;
import com.belz.bicontrolapi.service.ExcellCreator;
import com.belz.bicontrolapi.service.ISafUnidadesService;
import com.belz.bicontrolapi.viewModel.ExcellModel;
import com.belz.bicontrolapi.viewModel.common.CommonColumnsModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SafUnidadesService implements ISafUnidadesService {

    @Autowired
    SafUniadesCriteriaRepository safUniadesCriteriaRepository;

    @Autowired
    SafUnidadesRepository safUnidadesRepository;

    @Override
    public Page<SafUnidades> getUnidades(SafUnidadesPage page, SafUnidadesSearchCriteria searchCriteria) {
        return safUniadesCriteriaRepository.findAllWithFilters(page, searchCriteria);
    }

    public List<SafUnidades> getUnidadesToDownaload(SafUnidadesPage page, SafUnidadesSearchCriteria searchCriteria) {
        return safUniadesCriteriaRepository.findUnidadesToDownload(page, searchCriteria);
    }

    public  Workbook safUnidadesExcelReport(List<SafUnidades> unidades, CommonColumnsModel commonColumnsModel) {
        ExcellCreator creator = new ExcellCreator();
        Workbook workbook = creator.build(commonColumnsModel.getHeader(), commonColumnsModel.getSheetTitle(), ExcellModel.builder()
                .columnTitles(Arrays.asList(commonColumnsModel.getColumnLabels()))
                .modelFieldNames(Arrays.asList(commonColumnsModel.getColumnNames()))
                .data(unidades).build());

        return workbook;

    }
}
