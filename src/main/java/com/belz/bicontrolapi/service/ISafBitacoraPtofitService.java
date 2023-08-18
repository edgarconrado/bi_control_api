package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.dto.SafBitacoraPtofitDto;
import org.springframework.data.domain.Page;

public interface ISafBitacoraPtofitService {
    Page<SafBitacoraPtofitDto> getAll(Integer pageSize, Integer pageNumber);
}
