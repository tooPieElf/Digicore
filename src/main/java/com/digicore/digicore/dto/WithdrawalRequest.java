package com.digicore.digicore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawalRequest {
    String accountNumber;
    String accountPassword;
    Double withdrawnAmount;
}
