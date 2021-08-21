package com.digicore.digicore.controllers.bankTransaction;

import com.digicore.digicore.dto.accountCreation.CreateAccountDto;
import com.digicore.digicore.dto.accountTransaction.AccountDepositDto;
import com.digicore.digicore.dto.accountTransaction.AccountInfoDto;
import com.digicore.digicore.dto.accountTransaction.AccountWithdrawalDto;
import com.digicore.digicore.model.User;
import com.digicore.digicore.service.AccountService;
import com.digicore.digicore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;


    @GetMapping("/account_info/{accountNumber}")
    public ResponseEntity<AccountInfoDto> getAccountInfo(@PathVariable String accountNumber){
        return ResponseEntity.ok(userService.getAccountInfo(accountNumber));
    }

    @GetMapping("/account_statement/{accountNumber}")
    public ResponseEntity<?> getAccountStatement(@PathVariable String accountNumber){
        return ResponseEntity.ok(accountService.getTransactions(accountNumber));
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody AccountDepositDto accountDepositDto){
        return ResponseEntity.ok(accountService.deposit(accountDepositDto));
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<String> withdrawal(@RequestBody AccountWithdrawalDto accountWithdrawalDto){
        return ResponseEntity.ok(accountService.withdrawal(accountWithdrawalDto));
    }

    @PostMapping("/create_account")
    public ResponseEntity<User> createAccount(@RequestBody CreateAccountDto requestData){
        return ResponseEntity.ok(userService.createAccount(requestData));

    }
}
