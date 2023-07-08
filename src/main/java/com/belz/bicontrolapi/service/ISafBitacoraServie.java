package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.entity.SafBitacora;
import com.belz.bicontrolapi.filterModel.safBitacora.SafBitacoraPage;
import com.belz.bicontrolapi.filterModel.safBitacora.SafBitacoraSearchCriteria;
import org.springframework.data.domain.Page;

public interface ISafBitacoraServie {
    Page<SafBitacora> getBitacora(SafBitacoraPage safBitacoraPage, SafBitacoraSearchCriteria safBitacoraSearchCriteria);
}
