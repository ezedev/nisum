package com.nisum.demo.application.useCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.nisum.demo.application.Exceptions.*;
import com.nisum.demo.application.dto.*;
import com.nisum.demo.application.useCase.impl.CreateUser;
import com.nisum.demo.domain.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateUserTest {

    @InjectMocks
    CreateUser createUser;

    @Mock
    UserService userService;

    @Test
    void testExecute_ValidUserDto_ShouldCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setName("John Doe");
        userDto.setEmail("john@example.com");
        userDto.setPassword("Abc12345");

        when(userService.generateNewUser(userDto)).thenReturn(userDto);

        UserDto result = createUser.execute(userDto);

        assertNotNull(result);
        verify(userService, times(1)).generateNewUser(userDto);
    }


    @Test
    void testExecute_NullName_ShouldThrowFieldNullException() {
        UserDto userDto = new UserDto();
        assertThrows(FieldNullException.class, () -> createUser.execute(userDto));
    }

    @Test
    void testExecute_invalid_password() {
        UserDto userDto = new UserDto();
        userDto.setName("John Doe");
        userDto.setEmail("john@example.com");
        userDto.setPassword("aaa");
        assertThrows(InvalidPasswordException.class, () -> createUser.execute(userDto));
    }

    @Test
    void testExecute_invalid_email() {
        UserDto userDto = new UserDto();
        userDto.setName("John Doe");
        userDto.setEmail("aaa");
        userDto.setPassword("Abc12345");
        assertThrows(InvalidEmailException.class, () -> createUser.execute(userDto));
    }

    @Test
    void testExecute_NullEmail_ShouldThrowFieldNullException() {
        UserDto userDto = new UserDto();
        assertThrows(FieldNullException.class, () -> createUser.execute(userDto));
    }

    @Test
    void testExecute_NullPassword_ShouldThrowFieldNullException() {
        UserDto userDto = new UserDto();
        userDto.setName("John Doe");
        userDto.setEmail("aaa");
        assertThrows(FieldNullException.class, () -> createUser.execute(userDto));
    }


    @Test
    void testExecute_Nullemail_ShouldThrowFieldNullException() {
        UserDto userDto = new UserDto();
        userDto.setName("John Doe");
        assertThrows(FieldNullException.class, () -> createUser.execute(userDto));
    }

}
