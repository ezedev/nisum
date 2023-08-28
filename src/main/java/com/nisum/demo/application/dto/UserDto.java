package com.nisum.demo.application.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @ApiModelProperty(hidden = true)
    private UUID id;

    private String name;

    private String email;

    private String password;

    @ApiModelProperty(hidden = true)
    private LocalDateTime created;

    @ApiModelProperty(hidden = true)
    private LocalDateTime modified;

    @ApiModelProperty(hidden = true)
    private LocalDateTime lastLogin;

    @ApiModelProperty(hidden = true)
    private String token;

    @ApiModelProperty(hidden = true)
    private Boolean isActive;

    private List<PhoneDto> phones = new ArrayList<>();
}
