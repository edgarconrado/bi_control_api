package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.entity.SafAnticipos;
import com.belz.bicontrolapi.filterModel.safAnticipos.SafAnticiposPage;
import com.belz.bicontrolapi.filterModel.safAnticipos.SafAnticiposSearchCriteria;
import org.springframework.data.domain.Page;

public interface ISafAnticiposService {

    Page<SafAnticipos> getAnticipos(SafAnticiposPage safAnticiposPage, SafAnticiposSearchCriteria safAnticiposSearchCriteria);
}
