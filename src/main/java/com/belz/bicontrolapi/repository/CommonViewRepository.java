package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.util.PageModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CommonViewRepository <TView, TSearchCriteria>{
    Page<TView> findAllWithFilters(PageModel page, TSearchCriteria searchCriteria);

    List<TView> findAllWithFiltersList(PageModel page, TSearchCriteria searchCriteria);
}
