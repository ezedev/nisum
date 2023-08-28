package com.nisum.demo.domain.service;

import com.nisum.demo.application.dto.UserDto;

public interface UserService {

    UserDto generateNewUser(UserDto userDto);
}
