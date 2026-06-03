package com.kelbongcin.sistem_mahasiswa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // Izinkan semua akses tanpa login
            .csrf(csrf -> csrf.disable()); // Matikan CSRF untuk mempermudah form submit sementara
        return http.build();
    }
}