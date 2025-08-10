// src/main/java/com/example/authservice/response/JwtResponse.java
package com.example.authservice.response;

public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    // Getter for the token
    public String getToken() {
        return token;
    }

    // Setter for the token
    public void setToken(String token) {
        this.token = token;
    }
}