package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.util.PageModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ServiceUtil {
    protected Pageable getPageable(PageModel pageModel) {
        Sort sort = Sort.by(pageModel.getSortDirection(), pageModel.getSortBy());
        return PageRequest.of(pageModel.getPageNumber(), pageModel.getPageSize(), sort);
    }
}
