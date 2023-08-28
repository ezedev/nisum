package com.nisum.demo.infrastructure.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class H2DatabaseConfig {

    @PostConstruct
    public void init() {
        insert();
    }

    private void insert() {

    }
}
