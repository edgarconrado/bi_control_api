package com.belz.bicontrolapi.mapper;

import com.belz.bicontrolapi.dto.SafAnticiposDto;
import com.belz.bicontrolapi.dto.SafBitacoraPtofitDto;
import com.belz.bicontrolapi.entity.SafAnticipos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SafFletesMapper {
    SafAnticiposDto toDo(SafAnticipos entity);
    SafAnticipos toEntity(SafBitacoraPtofitDto dto);
}
