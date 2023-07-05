package com.belz.bicontrolapi.filterModel.safViajes;

import com.belz.bicontrolapi.viewModel.common.CommonColumnsModel;
import lombok.Data;

@Data
public class SafViajesFilter {

    SafViajesPage safViajesPage;
    SafViajesSearchCriteria safViajesSearchCriteria;
    CommonColumnsModel safViajesCommonColumnsModel;
}
