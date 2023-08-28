package com.nisum.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.nisum.demo.application.dto.PhoneDto;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class PhoneDtoTest {

    @Test
    void testIdGetterSetter() {
        UUID id = UUID.randomUUID();
        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setId(id);
        UUID retrievedId = phoneDto.getId();

        assertEquals(id, retrievedId);
    }

    @Test
    void testNumberGetterSetter() {
        String number = "123456789";
        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setNumber(number);
        String retrievedNumber = phoneDto.getNumber();

        assertEquals(number, retrievedNumber);
    }

    @Test
    void testCityCodeGetterSetter() {
        String cityCode = "123";
        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setCityCode(cityCode);
        String retrievedCityCode = phoneDto.getCityCode();

        assertEquals(cityCode, retrievedCityCode);
    }

    @Test
    void testCountryCodeGetterSetter() {
        String countryCode = "+1";
        PhoneDto phoneDto = new PhoneDto();

        phoneDto.setCountryCode(countryCode);
        String retrievedCountryCode = phoneDto.getCountryCode();

        assertEquals(countryCode, retrievedCountryCode);
    }
}
