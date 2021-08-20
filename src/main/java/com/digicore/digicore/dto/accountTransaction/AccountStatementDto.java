package com.digicore.digicore.dto.accountTransaction;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class AccountStatementDto {
    private Date transactionDate;
    private String transactionType;
    private String narration;
    private Double amount;
    private Double accountBalance;
}
