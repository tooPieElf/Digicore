package com.digicore.digicore.dto.accountTransaction;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccountDepositDto {
    @NotNull
    String accountNumber;
    @NotNull
    Double amount;
}
