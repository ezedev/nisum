package com.nisum.demo.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.nisum.demo.domain.model.NisumUser;
import com.nisum.demo.application.dto.UserDto;

import com.nisum.demo.application.Exceptions.EmailAlreadyExistsException;
import com.nisum.demo.domain.service.impl.UserServiceImpl;
import com.nisum.demo.infrastructure.config.exceptions.DatabaseException;
import com.nisum.demo.infrastructure.mapper.UserMapper;
import com.nisum.demo.infrastructure.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @Test
    void testGenerateNewUser_NewUser_ShouldCreateUserDto() {
        UserDto userDto = new UserDto();
        NisumUser nisumUser = new NisumUser();

        when(userMapper.toEntity(userDto)).thenReturn(nisumUser);
        when(userRepository.existsByEmail(userDto.getEmail())).thenReturn(false);
        when(userMapper.toDto(nisumUser)).thenReturn(userDto);

        UserDto result = userService.generateNewUser(userDto);

        assertNotNull(result);
        verify(userRepository, times(1)).save(nisumUser);
    }

    @Test
    void testGenerateNewUser_ExistingEmail_ShouldThrowEmailAlreadyExistsException() {
        UserDto userDto = new UserDto();
        when(userRepository.existsByEmail(userDto.getEmail())).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> userService.generateNewUser(userDto));
    }

    @Test
    void testGenerateNewUser_DatabaseError_ShouldThrowDatabaseException() {
        UserDto userDto = new UserDto();
        NisumUser nisumUser = new NisumUser();

        when(userRepository.existsByEmail(userDto.getEmail())).thenReturn(false);
        when(userRepository.save(nisumUser)).thenThrow(new RuntimeException());

        assertThrows(DatabaseException.class, () -> userService.generateNewUser(userDto));
    }
}
