// src/main/java/com/example/authservice/service/JwtService.java
package com.example.authservice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret}") // Injected from application.properties
    private String secretKey;

    @Value("${jwt.expiration}") // Injected from application.properties (in milliseconds)
    private long jwtExpiration;

    // Decodes the Base64 secret key and converts it to a SecretKey object for signing
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generates a JWT token for the given username
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>(); // You can add custom claims here if needed
        return createToken(claims, username);
    }

    // Helper method to actually build the JWT string
    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .claims(claims) // Set any custom claims
                .subject(username) // Set the subject of the token (typically the username)
                .issuedAt(new Date(System.currentTimeMillis())) // Set the token issuance time
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration)) // Set the token expiration time
                .signWith(getSigningKey(), Jwts.SIG.HS256) // Sign the token with our secret key using HS256 algorithm
                .compact(); // Compacts the JWT into a URL-safe string
    }
}