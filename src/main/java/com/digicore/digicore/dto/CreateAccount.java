package com.digicore.digicore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccount {
    String accountName;
    String accountPassword;
    Double initialDeposit;
}
