package com.digicore.digicore.dto.accountCreation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;


@Getter
@Setter
 public class CreateAccountDto {
    private String accountName;
    private String accountPassword;
    @Min(value = 500, message = "initial deposit must be greater or equal to 500 Naira")
    private Double initialDeposit;
}
