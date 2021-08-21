package com.digicore.digicore.service;

import com.digicore.digicore.apiResponse.ApiResponse;
import com.digicore.digicore.dto.accountCreation.CreateAccountDto;
import com.digicore.digicore.dto.accountTransaction.AccountInfoDto;
import com.digicore.digicore.model.User;
import com.digicore.digicore.repository.TransactionRepository;
import com.digicore.digicore.repository.UserRepository;
import com.digicore.digicore.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountNumberGenerator<String> accountNumberGenerator;


    public User createAccount(@Valid CreateAccountDto createAccountDto){
        User user = new User();
        PasswordUtils passwordUtils = new PasswordUtils();
        String encodedPassword = passwordUtils.encode(createAccountDto.getAccountPassword());
        user.setAccountPassword(encodedPassword);
        //TODO :: Throw neccessary error here
        if(checkAccountName(createAccountDto.getAccountName())){
            user.setAccountName(createAccountDto.getAccountName());
        }
        String accountNumber = accountNumberGenerator.generateAccount();
        //TODO :: Throw neccessary error here
        if(checkAccountNumber(accountNumber)){
            user.setAccountNumber(accountNumber);
        }
        user.setAccountBalance(BigDecimal.valueOf(createAccountDto.getInitialDeposit()));
        return userRepository.save(user);
    }

    @Override
    public AccountInfoDto getAccountInfo(String accountNumber) {
       User user = userRepository.findByAccountNumber(accountNumber);
       AccountInfoDto accountInfoDto = new AccountInfoDto();
       accountInfoDto.setAccountName(user.getAccountName());
       accountInfoDto.setAccountNumber(user.getAccountNumber());
       accountInfoDto.setBalance(user.getAccountBalance().doubleValue());
       return accountInfoDto;
    }

    private boolean checkAccountNumber(String accountNumber) {
       return null == userRepository.findByAccountNumber(accountNumber);
    }

    private boolean checkAccountName(String userName) {
        return null == userRepository.findByAccountName(userName);
    }

}
