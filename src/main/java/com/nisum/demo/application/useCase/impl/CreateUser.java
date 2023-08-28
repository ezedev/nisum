package com.nisum.demo.application.useCase.impl;

import com.nisum.demo.application.Exceptions.FieldNullException;
import com.nisum.demo.application.Exceptions.InvalidEmailException;
import com.nisum.demo.application.Exceptions.InvalidPasswordException;
import com.nisum.demo.application.Exceptions.PhoneFieldNullException;
import com.nisum.demo.application.dto.PhoneDto;
import com.nisum.demo.application.dto.UserDto;
import com.nisum.demo.application.useCase.CreateUserUseCase;
import com.nisum.demo.domain.service.UserService;
import com.nisum.demo.infrastructure.Utils.RegexUtils;
import com.nisum.demo.infrastructure.config.jwt.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@AllArgsConstructor
public class CreateUser implements CreateUserUseCase {

    private final UserService userService;

    @Override
    public UserDto execute(UserDto userDto) {
        validateRequestUser(userDto);
        validateEmail(userDto);
        validatePassword(userDto);

        LocalDateTime now = LocalDateTime.now();

        UUID userId = generateUniqueId();
        userDto.setId(userId);

        List<PhoneDto> phones = userDto.getPhones();
        phones.forEach(phone -> phone.setId(generateUniqueId()));

        userDto.setCreated(now);
        userDto.setModified(now);
        userDto.setLastLogin(now);

        userDto.setIsActive(Boolean.TRUE);

        String jwtToken = JwtProvider.generateJwtToken(userDto.getEmail());
        userDto.setToken(jwtToken);

        return userService.generateNewUser(userDto);
    }

    private void validatePassword(UserDto userDto) {
        if (!RegexUtils.isValidPassword(userDto.getPassword())) {
            throw new InvalidPasswordException("Invalid password format");
        }
    }

    private void validateEmail(UserDto userDto) {
        if (!isValidEmail(userDto.getEmail())) {
            throw new InvalidEmailException("Invalid email format");
        }
    }

    private static void validateRequestPhones(UserDto userDto) {
        for (PhoneDto phone : userDto.getPhones()) {
            if (phone.getNumber() == null) {
                throw new PhoneFieldNullException("Número");
            }
            if (phone.getCityCode() == null) {
                throw new PhoneFieldNullException("Código de ciudad");
            }
            if (phone.getCountryCode() == null) {
                throw new PhoneFieldNullException("Código de país");
            }
        }
    }

    private static void validateRequestUser(UserDto userDto) {
        if (userDto.getName() == null) {
            throw new FieldNullException("Nombre");
        }
        if (userDto.getEmail() == null) {
            throw new FieldNullException("Email");
        }
        if (userDto.getPassword() == null) {
            throw new FieldNullException("Contraseña");
        }
        validateRequestPhones(userDto);
    }

    private UUID generateUniqueId() {
        return UUID.randomUUID();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
