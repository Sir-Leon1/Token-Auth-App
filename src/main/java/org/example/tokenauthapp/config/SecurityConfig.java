package org.example.tokenauthapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http  // Disable CSRF protection for simplicity (not recommended for production)
                .csrf(csrf -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/authenticate").permitAll()  // Allow unauthenticated access to the /authenticate endpoint
                .anyRequest().authenticated();  // Require authentication for any other request
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Bean for password encoding using BCrypt
    }
}
