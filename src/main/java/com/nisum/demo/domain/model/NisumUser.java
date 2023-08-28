package com.nisum.demo.domain.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class NisumUser {

    @Id
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private LocalDateTime created;

    private LocalDateTime modified;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    private String token;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nisumUser")
    private List<Phone> phones = new ArrayList<>();
}