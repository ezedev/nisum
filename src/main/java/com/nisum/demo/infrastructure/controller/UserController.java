package com.nisum.demo.infrastructure.controller;

import com.nisum.demo.application.dto.UserDto;
import com.nisum.demo.application.useCase.CreateUserUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/nisum")
@Api(tags = "User Management")
public class UserController {

    private final CreateUserUseCase createUser;

    @PostMapping(value = "/user")
    @ApiOperation(value = "Create a new user")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(createUser.execute(userDto), HttpStatus.CREATED);
    }
}
