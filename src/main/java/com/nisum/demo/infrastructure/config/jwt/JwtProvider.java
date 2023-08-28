package com.nisum.demo.infrastructure.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class JwtProvider {

    @Getter
    private static final String jwtSecret = "9g4Wd3t7RfP2yHjN6mZqAeS8uB5cVxYk\n";

    public static String generateJwtToken(String email) {
        Claims claims = Jwts.claims().setSubject(email);
        Instant now = Instant.now();
        Instant expiration = now.plus(Duration.ofHours(2)); // Token expira en 2 horas

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }

    public static boolean isTokenExpired(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            Date expirationDate = claims.getExpiration();
            Instant now = Instant.now();
            return expirationDate.toInstant().isBefore(now);
        } catch (Exception e) {
            // En caso de error en el análisis del token, se considera como token expirado
            return true;
        }
    }
}

