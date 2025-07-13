// src/main/java/com/example/authservice/controller/AuthenticationController.java
package com.example.authservice.controller;

import com.example.authservice.response.JwtResponse;
import com.example.authservice.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate") // Maps this controller to the /authenticate endpoint
public class AuthenticationController {

    private final AuthenticationManager authenticationManager; // Injected for authentication logic
    private final JwtService jwtService; // Injected for JWT generation

    // Constructor for dependency injection
    public AuthenticationController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Handles GET requests to /authenticate
    @GetMapping
    public ResponseEntity<?> authenticateUser() {
        // When this method is reached, Spring Security's Basic Authentication filter
        // has already successfully processed the "Authorization: Basic" header.
        // If the credentials were invalid, Spring Security would have returned a 401
        // BEFORE this method is ever called.

        // Retrieve the Authentication object from the SecurityContext.
        // This object contains the successfully authenticated user details.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Basic check: Ensure authentication is not null and is indeed authenticated.
        // This condition should generally be true if the method is reached.
        if (authentication == null || !authentication.isAuthenticated()) {
            System.err.println("Authentication object is null or not authenticated. This indicates a configuration error.");
            return ResponseEntity.status(401).body("Authentication failed or incomplete processing.");
        }

        // Get the UserDetails (principal) from the authenticated object.
        // This gives us access to the username, roles, etc.
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        System.out.println("User '" + username + "' successfully authenticated via Basic Auth. Now generating JWT...");

        // Generate the JWT token using our JwtService
        String token = jwtService.generateToken(username);

        // Return the JWT token in a JSON response
        return ResponseEntity.ok(new JwtResponse(token));
    }
}