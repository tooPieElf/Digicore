package com.digicore.digicore.service;

import com.digicore.digicore.dto.accountTransaction.AccountDepositDto;
import com.digicore.digicore.dto.accountTransaction.AccountWithdrawalDto;
import com.digicore.digicore.model.Transaction;
import com.digicore.digicore.model.User;
import com.digicore.digicore.repository.TransactionRepository;
import com.digicore.digicore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Transaction> getTransactions(String accountNumber) {
        User user = userRepository.findByAccountNumber(accountNumber);
        return user.getTransactionList();
    }

    @Override
    public String deposit(AccountDepositDto accountDepositDto) {
        User user = userRepository.findByAccountNumber(accountDepositDto.getAccountNumber());
        Transaction transaction = new Transaction();
        if(accountDepositDto.getAmount()>1000000 || accountDepositDto.getAmount()<1){
            // TODO :: Throw execption here;
        }else{
            transaction.setTransactionDate(Date.from(Instant.now()));
            transaction.setTransactionType("Deposit");
            transaction.setAmount(accountDepositDto.getAmount());
            BigDecimal accountBalance = user.getAccountBalance();
            BigDecimal balance = accountBalance.add(BigDecimal.valueOf(accountDepositDto.getAmount()));
            transaction.setAvailableBalance(balance);
            transaction.setUser(user);
            user.setAccountBalance(balance);
        }
        transactionRepository.save(transaction);
        userRepository.save(user);
        return "successfully deposited";
    }

    @Override
    public String withdrawal(AccountWithdrawalDto accountWithdrawalDto) {
        try {
            User user = userRepository.findByAccountNumber(accountWithdrawalDto.getAccountNumber());
            Transaction transaction = new Transaction();
            BigDecimal remainingBalance = user.getAccountBalance().subtract(BigDecimal.valueOf(accountWithdrawalDto.getWithdrawnAmount()));
            if(accountWithdrawalDto.getWithdrawnAmount()<1 || remainingBalance.doubleValue()<500 ){
                //TODO :: Throw Bad request code here
            }else{
                transaction.setTransactionDate(Date.from(Instant.now()));
//                transaction.setTransactionType("withdrawal");
                transaction.setAmount(accountWithdrawalDto.getWithdrawnAmount());
                BigDecimal accountBalance = user.getAccountBalance();
                BigDecimal balance = accountBalance.subtract(BigDecimal.valueOf(accountWithdrawalDto.getWithdrawnAmount()));
                transaction.setAvailableBalance(balance);
                transaction.setUser(user);
                user.setAccountBalance(balance);
                transactionRepository.save(transaction);
                userRepository.save(user);
            }

            return "Successfully withdrawn";
        }catch (Exception ex){
            return ex.getMessage();
        }

    }
}
