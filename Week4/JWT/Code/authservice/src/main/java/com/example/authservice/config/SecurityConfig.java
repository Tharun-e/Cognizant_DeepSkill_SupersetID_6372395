// src/main/java/com/example/authservice/config/SecurityConfig.java
package com.example.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // Enables @PreAuthorize for future method-level security
public class SecurityConfig {

    // 1. PasswordEncoder: Defines how passwords are hashed and verified.
    // We use BCryptPasswordEncoder, a strong, widely accepted algorithm.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. UserDetailsService: Tells Spring Security where to find user details.
    // For this example, we're setting up an in-memory user for simplicity.
    // In a real application, this would typically fetch users from a database.
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Define our test user "user" with password "pwd".
        // The password "pwd" MUST be encoded using the passwordEncoder.
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("pwd")) // <--- Password "pwd" is encoded here
                .roles("USER") // Assign a role (e.g., "USER")
                .build();
        // Return an InMemoryUserDetailsManager containing our defined user(s).
        return new InMemoryUserDetailsManager(user);
    }

    // 3. AuthenticationManager: Orchestrates the actual authentication process.
    // It uses the UserDetailsService to load user details and PasswordEncoder to verify passwords.
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService); // Provide our user details service
        authenticationProvider.setPasswordEncoder(passwordEncoder);       // Provide our password encoder
        return new ProviderManager(authenticationProvider); // Create and return the manager
    }

    // 4. SecurityFilterChain: Configures the HTTP security rules for our application.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for API endpoints (common for stateless APIs)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // JWTs are stateless, no server-side sessions
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/authenticate").permitAll() // Allow /authenticate endpoint to be accessed without prior authentication
                .anyRequest().authenticated() // All other requests require authentication
            )
            .httpBasic(httpBasic -> {}); // Enable HTTP Basic authentication for initial login on /authenticate

        return http.build(); // Build and return the configured SecurityFilterChain
    }
}