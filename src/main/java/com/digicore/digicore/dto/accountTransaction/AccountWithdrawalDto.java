package com.digicore.digicore.dto.accountTransaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountWithdrawalDto {
    String accountNumber;
    String accountPassword;
    Double withdrawnAmount;
}
