package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.dto.SafBitacoraDto;
import org.springframework.data.domain.Page;

public interface ISafBitacoraService {
    Page<SafBitacoraDto> getAll(Integer pageSize, Integer pageNumber);
}
