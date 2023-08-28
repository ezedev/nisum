package com.nisum.demo.application.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PhoneDto {

    @ApiModelProperty(hidden = true)
    private UUID id;

    private String number;

    private String cityCode;

    private String countryCode;
}
