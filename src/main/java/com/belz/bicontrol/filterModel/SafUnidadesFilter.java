package com.belz.bicontrol.filterModel;

import com.belz.bicontrol.viewModel.common.CommonColumnsModel;
import lombok.Data;

@Data
public class SafUnidadesFilter {
    SafUnidadesPage unidadesPage;
    SafUnidadesSearchCriteria unidadesSearchCriteria;
    CommonColumnsModel unidadesColumnsModel;

}
