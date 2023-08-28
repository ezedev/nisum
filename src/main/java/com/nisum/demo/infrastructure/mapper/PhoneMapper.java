package com.nisum.demo.infrastructure.mapper;

import com.nisum.demo.application.dto.PhoneDto;
import com.nisum.demo.domain.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    PhoneDto toDto(Phone source);

    Phone toEntity(PhoneDto source);
}
