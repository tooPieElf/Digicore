package com.digicore.digicore.dto.accountCreation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 public class CreateAccountDto {
    private String accountName;
    private String accountPassword;
    private Double initialDeposit;
}
