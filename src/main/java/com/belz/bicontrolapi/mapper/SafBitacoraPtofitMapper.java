package com.belz.bicontrolapi.mapper;

import com.belz.bicontrolapi.dto.SafBitacoraPtofitDto;
import com.belz.bicontrolapi.entity.SafBitacoraPtofit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SafBitacoraPtofitMapper {
    SafBitacoraPtofitDto toDto(SafBitacoraPtofit entity);
    SafBitacoraPtofit toEntity(SafBitacoraPtofitDto dto);
}
