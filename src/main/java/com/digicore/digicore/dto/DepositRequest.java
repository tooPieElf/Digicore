package com.digicore.digicore.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositRequest {
    String accountNumber;
    Double amount;
}
