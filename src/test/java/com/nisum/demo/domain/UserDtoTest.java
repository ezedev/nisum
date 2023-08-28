package com.nisum.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.nisum.demo.application.dto.PhoneDto;
import com.nisum.demo.application.dto.UserDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class UserDtoTest {

    @Test
    void testIdGetterSetter() {
        UUID id = UUID.randomUUID();
        UserDto userDto = new UserDto();

        userDto.setId(id);
        UUID retrievedId = userDto.getId();

        assertEquals(id, retrievedId);
    }

    @Test
    void testNameGetterSetter() {
        String name = "John Doe";
        UserDto userDto = new UserDto();

        userDto.setName(name);
        String retrievedName = userDto.getName();

        assertEquals(name, retrievedName);
    }

    @Test
    void testPhonesGetterSetter() {
        List<PhoneDto> phones = new ArrayList<>();
        phones.add(new PhoneDto());
        phones.add(new PhoneDto());
        UserDto userDto = new UserDto();

        userDto.setPhones(phones);
        List<PhoneDto> retrievedPhones = userDto.getPhones();
        assertEquals(phones, retrievedPhones);
    }

    @Test
    void testPhoneListNotNullByDefault() {
        UserDto userDto = new UserDto();

        List<PhoneDto> phones = userDto.getPhones();

        assertNotNull(phones);
    }

    @Test
    void testUserDtoToString() {
        UserDto userDto = new UserDto();
        userDto.setId(UUID.randomUUID());
        userDto.setName("John Doe");

        String toString = userDto.toString();

        assertNotNull(toString);
    }

    @Test
    void testCreatedGetterSetter() {
        LocalDateTime created = LocalDateTime.now();
        UserDto userDto = new UserDto();

        userDto.setCreated(created);
        LocalDateTime retrievedCreated = userDto.getCreated();

        assertEquals(created, retrievedCreated);
    }

    @Test
    void testModifiedGetterSetter() {
        LocalDateTime modified = LocalDateTime.now();
        UserDto userDto = new UserDto();

        userDto.setModified(modified);
        LocalDateTime retrievedModified = userDto.getModified();

        assertEquals(modified, retrievedModified);
    }

    @Test
    void testLastLoginGetterSetter() {
        LocalDateTime lastLogin = LocalDateTime.now();
        UserDto userDto = new UserDto();

        userDto.setLastLogin(lastLogin);
        LocalDateTime retrievedLastLogin = userDto.getLastLogin();

        assertEquals(lastLogin, retrievedLastLogin);
    }

    @Test
    void testTokenGetterSetter() {
        String token = "example-token";
        UserDto userDto = new UserDto();

        userDto.setToken(token);
        String retrievedToken = userDto.getToken();

        assertEquals(token, retrievedToken);
    }

    @Test
    void testIsActiveGetterSetter() {
        boolean isActive = true;
        UserDto userDto = new UserDto();

        userDto.setIsActive(isActive);
        boolean retrievedIsActive = userDto.getIsActive();
        
        assertEquals(isActive, retrievedIsActive);
    }
}
