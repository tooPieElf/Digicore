package com.digicore.digicore.model;

import com.digicore.digicore.dto.accountTransaction.AccountStatementDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    private Long id;
    private String accountNumber;
    private BigDecimal accountBalance;
    @OneToOne
    private User user;
    @OneToMany
    private List<Transaction> transactionList;
}
