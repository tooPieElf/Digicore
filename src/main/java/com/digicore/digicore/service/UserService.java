package com.digicore.digicore.service;

import com.digicore.digicore.apiResponse.ApiResponse;
import com.digicore.digicore.dto.accountCreation.CreateAccountDto;
import com.digicore.digicore.dto.accountTransaction.AccountInfoDto;
import com.digicore.digicore.model.User;

public interface UserService {
    User createAccount(CreateAccountDto createAccount);
    AccountInfoDto getAccountInfo(String accountNumber);
}
