package com.nisum.demo.infrastructure.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OpenSwaggerUIRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Runtime.getRuntime().exec("open http://localhost:8080/swagger-ui/#/");
    }
}
