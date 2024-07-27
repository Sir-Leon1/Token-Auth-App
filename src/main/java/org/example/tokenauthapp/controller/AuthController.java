package org.example.tokenauthapp.controller;

import org.example.tokenauthapp.config.SecurityConfig;
import org.example.tokenauthapp.service.JwtTokenProvider;
import org.example.tokenauthapp.model.AuthRequest;
import org.example.tokenauthapp.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Value("${user.username}")
    private String storedUsername;

    @Value("${user.password}")
    private String storedPassword;

    @Autowired
    private SecurityConfig securityConfig;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        if (storedUsername.equals(authRequest.getUsername()) && securityConfig.passwordEncoder().matches(authRequest.getPassword(), storedPassword)) {
            String token = jwtTokenProvider.createToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


}