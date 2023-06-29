package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.entity.SafViajes;
import com.belz.bicontrolapi.filterModel.safViajes.SafViajesPage;
import com.belz.bicontrolapi.filterModel.safViajes.SafViajesSearchCriteria;
import com.belz.bicontrolapi.repository.SafViajesCriteriaRepository;
import com.belz.bicontrolapi.repository.SafViajesRepository;
import com.belz.bicontrolapi.service.ExcellCreator;
import com.belz.bicontrolapi.service.ISafViajesService;
import com.belz.bicontrolapi.viewModel.ExcellModel;
import com.belz.bicontrolapi.viewModel.common.CommonColumnsModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SafViajesService implements ISafViajesService {

    @Autowired
    SafViajesCriteriaRepository safViajesCriteriaRepository;

    @Autowired
    SafViajesRepository safViajesRepository;


    @Override
    public Page<SafViajes> getViajes(SafViajesPage page, SafViajesSearchCriteria searchCriteria) {
        return safViajesCriteriaRepository.findAllWithFilters(page, searchCriteria);
    }

    public List<SafViajes> getViajesToDownload(SafViajesPage page, SafViajesSearchCriteria searchCriteria) {
        return safViajesCriteriaRepository.findViajesToDownload(page, searchCriteria);
    }

    public Workbook safViajesExcelReport(List<SafViajes> viajes, CommonColumnsModel commonColumnsModel) {
        ExcellCreator creator = new ExcellCreator();
        Workbook workbook = creator.build(commonColumnsModel.getHeader(), commonColumnsModel.getSheetTitle(), ExcellModel.builder()
                .columnTitles(Arrays.asList(commonColumnsModel.getColumnLabels()))
                .modelFieldNames(Arrays.asList(commonColumnsModel.getColumnNames()))
                .data(viajes).build());

        return workbook;
    }
}
