package com.digicore.digicore.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordUtils {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }

}
