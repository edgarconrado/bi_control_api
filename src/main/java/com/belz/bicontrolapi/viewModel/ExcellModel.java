package com.belz.bicontrolapi.viewModel;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExcellModel {

    private List<String> columnTitles;
    private List<String> modelFieldNames;
    private List<? extends Object> data;
}
