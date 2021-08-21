package com.digicore.digicore.service;

import com.digicore.digicore.dto.accountTransaction.AccountDepositDto;
import com.digicore.digicore.dto.accountTransaction.AccountWithdrawalDto;
import com.digicore.digicore.model.Transaction;

import java.util.List;

public interface AccountService {
    List<Transaction> getTransactions(String accountNumber);
    String deposit (AccountDepositDto accountDepositDto);
    String withdrawal(AccountWithdrawalDto accountWithdrawalDto);
}
