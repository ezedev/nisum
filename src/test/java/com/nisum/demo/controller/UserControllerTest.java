package com.nisum.demo.controller;

import com.nisum.demo.application.dto.UserDto;
import com.nisum.demo.application.useCase.CreateUserUseCase;
import com.nisum.demo.infrastructure.controller.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    CreateUserUseCase createUser;

    @Test
    void testCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setName("Nisum");
        UserDto createdUserDto = new UserDto();
        createdUserDto.setName("Nisum");

        when(createUser.execute(userDto)).thenReturn(createdUserDto);

        ResponseEntity<UserDto> response = userController.create(userDto);

        verify(createUser, times(1)).execute(userDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdUserDto, response.getBody());
    }
}
