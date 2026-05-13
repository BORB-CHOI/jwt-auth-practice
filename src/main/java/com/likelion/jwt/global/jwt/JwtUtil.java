package com.likelion.jwt.global.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username, String role) {
        // 빈칸
    }

    public String getUsername(String token) {
        // 빈칸
    }

    public boolean isValid(String token) {
        // 빈칸
    }

    private Claims getClaims(String token) {
        // 빈칸
    }

    private SecretKey getSigningKey() {
        // 빈칸
    }
}
