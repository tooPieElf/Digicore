package com.digicore.digicore.dto.accountTransaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountInfoDto {
    private String accountName;
    private String accountNumber;
    private Double balance;
}
