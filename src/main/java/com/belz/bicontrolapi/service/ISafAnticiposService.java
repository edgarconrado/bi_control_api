package com.belz.bicontrolapi.service;

import com.belz.bicontrolapi.dto.SafAnticiposDto;
import org.springframework.data.domain.Page;

public interface ISafAnticiposService {
    Page<SafAnticiposDto> getAll(Integer pageSize, Integer pageNumber);
}
