package com.belz.bicontrolapi.mapper;

import com.belz.bicontrolapi.dto.SafBitacoraDto;
import com.belz.bicontrolapi.entity.SafBitacora;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SafBitacoraMapper {
    SafBitacoraDto toDo(SafBitacora entity);
    SafBitacora toEntity(SafBitacoraDto dto);
}
