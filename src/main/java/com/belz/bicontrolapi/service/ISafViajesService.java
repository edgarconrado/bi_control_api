package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.dto.SafViajesDto;
import org.springframework.data.domain.Page;

public interface ISafViajesService {
    Page<SafViajesDto> getAll(Integer pageSize, Integer pageNumber);
}
