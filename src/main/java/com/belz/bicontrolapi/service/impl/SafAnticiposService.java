package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.entity.SafAnticipos;
import com.belz.bicontrolapi.filterModel.safAnticipos.SafAnticiposPage;
import com.belz.bicontrolapi.filterModel.safAnticipos.SafAnticiposSearchCriteria;
import com.belz.bicontrolapi.repository.SafAnticiposCriteriaRepository;
import com.belz.bicontrolapi.repository.SafAnticiposRepository;
import com.belz.bicontrolapi.service.ExcellCreator;
import com.belz.bicontrolapi.service.ISafAnticiposService;
import com.belz.bicontrolapi.viewModel.ExcellModel;
import com.belz.bicontrolapi.viewModel.common.CommonColumnsModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SafAnticiposService implements ISafAnticiposService {

    @Autowired
    SafAnticiposCriteriaRepository safAnticiposCriteriaRepository;

    @Autowired
    SafAnticiposRepository safAnticiposRepository;

    public Page<SafAnticipos> getAnticipos(SafAnticiposPage page, SafAnticiposSearchCriteria searchCriteria) {
        return safAnticiposCriteriaRepository.findAllWithFilters(page, searchCriteria);
    }

    public List<SafAnticipos> getViajesToDownload(SafAnticiposPage page, SafAnticiposSearchCriteria searchCriteria) {
        return safAnticiposCriteriaRepository.findAnticiposToDownload(page, searchCriteria);
    }

    public Workbook safViajesExcelReport(List<SafAnticipos> anticipos, CommonColumnsModel commonColumnsModel) {
        ExcellCreator creator = new ExcellCreator();
        Workbook workbook = creator.build(commonColumnsModel.getHeader(), commonColumnsModel.getSheetTitle(), ExcellModel.builder()
                .columnTitles(Arrays.asList(commonColumnsModel.getColumnLabels()))
                .modelFieldNames(Arrays.asList(commonColumnsModel.getColumnNames()))
                .data(anticipos).build());

        return workbook;
    }
}
