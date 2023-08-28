package com.nisum.demo.application.useCase;

import com.nisum.demo.application.dto.UserDto;

@FunctionalInterface
public interface CreateUserUseCase {

    UserDto execute(UserDto userDto);
}
