package com.digicore.digicore.controllers.bankTransaction;

import com.digicore.digicore.dto.accountTransaction.AccountDepositDto;
import com.digicore.digicore.dto.accountCreation.LoginDto;
import com.digicore.digicore.dto.accountTransaction.AccountWithdrawalDto;
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

    @GetMapping("/account_info/{accountNumber}")
    public ResponseEntity<?> getAccountInfo(@PathVariable String accountNumber){
        return null;
    }

    @GetMapping("/account_statement/{accountNumber}")
    public ResponseEntity<?> getAccountStatement(@PathVariable String accountNumber){
        return null;
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody AccountDepositDto accountDepositDto){

        return null;
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<?> withdrawal(@RequestBody AccountWithdrawalDto requestData){
        return null;
    }

}
