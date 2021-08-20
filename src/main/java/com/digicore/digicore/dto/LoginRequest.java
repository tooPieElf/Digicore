package com.digicore.digicore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    String accountNumber;
    String accountPassword;
}
