package com.belz.bicontrolapi.filterModel.safBitacora;

import com.belz.bicontrolapi.viewModel.common.CommonColumnsModel;
import lombok.Data;

@Data
public class SafBitacoraFilter {
    SafBitacoraPage safBitacoraPage;
    SafBitacoraSearchCriteria safBitacoraSearchCriteria;
    CommonColumnsModel safBitacoraCommonColumnsModel;
}
