package com.exemple.billing_module.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // désactiver CSRF
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // autoriser toutes les requêtes
            );
        return http.build();
    }
}
