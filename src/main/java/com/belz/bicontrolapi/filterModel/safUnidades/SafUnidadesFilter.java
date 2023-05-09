package com.belz.bicontrolapi.filterModel.safUnidades;

import com.belz.bicontrolapi.viewModel.common.CommonColumnsModel;
import lombok.Data;

@Data
public class SafUnidadesFilter {
    SafUnidadesPage safUnidadesPage;
    SafUnidadesSearchCriteria safUnidadesSearchCriteria;
    CommonColumnsModel safUnidadadesCommonColumnsModel;
}
