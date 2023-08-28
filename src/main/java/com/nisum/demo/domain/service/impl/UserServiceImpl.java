package com.nisum.demo.domain.service.impl;

import com.nisum.demo.application.Exceptions.EmailAlreadyExistsException;
import com.nisum.demo.application.dto.UserDto;
import com.nisum.demo.domain.model.NisumUser;
import com.nisum.demo.domain.service.UserService;
import com.nisum.demo.infrastructure.config.exceptions.DatabaseException;
import com.nisum.demo.infrastructure.mapper.UserMapper;
import com.nisum.demo.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDto generateNewUser(UserDto userDto) {
        if (emailExists(userDto.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        NisumUser nisumUser = userMapper.toEntity(userDto);
        try {
            userRepository.save(nisumUser);
        } catch (Exception e) {
            throw new DatabaseException("Error saving user data.", e);
        }
        return userMapper.toDto(nisumUser);
    }

    private boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
