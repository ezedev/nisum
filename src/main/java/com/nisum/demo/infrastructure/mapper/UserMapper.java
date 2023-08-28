package com.nisum.demo.infrastructure.mapper;


import com.nisum.demo.application.dto.UserDto;
import com.nisum.demo.domain.model.NisumUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PhoneMapper.class})
public interface UserMapper {

    UserDto toDto(NisumUser source);

    NisumUser toEntity(UserDto source);
}
