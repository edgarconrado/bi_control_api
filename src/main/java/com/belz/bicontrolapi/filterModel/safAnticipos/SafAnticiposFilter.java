package com.belz.bicontrolapi.filterModel.safAnticipos;

import com.belz.bicontrolapi.viewModel.common.CommonColumnsModel;
import lombok.Data;

@Data
public class SafAnticiposFilter {

    SafAnticiposPage safAnticiposPage;
    SafAnticiposSearchCriteria safAnticiposSearchCriteria;
    CommonColumnsModel safAntiCommonColumnsModel;
}
