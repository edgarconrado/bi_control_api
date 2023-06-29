package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.entity.SafViajes;
import com.belz.bicontrolapi.filterModel.safViajes.SafViajesPage;
import com.belz.bicontrolapi.filterModel.safViajes.SafViajesSearchCriteria;
import org.springframework.data.domain.Page;

public interface ISafViajesService {
    Page<SafViajes> getViajes(SafViajesPage safViajesPage, SafViajesSearchCriteria safViajesSearchCriteria);
}
