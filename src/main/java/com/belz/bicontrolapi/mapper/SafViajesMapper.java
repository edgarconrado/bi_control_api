package com.belz.bicontrolapi.mapper;

import com.belz.bicontrolapi.dto.SafViajesDto;
import com.belz.bicontrolapi.entity.SafViajes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SafViajesMapper {
    SafViajesDto toDo(SafViajes entity);
    SafViajes toEntity(SafViajesDto dto);
}
