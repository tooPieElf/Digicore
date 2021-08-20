package com.digicore.digicore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long Id;
    private Date transactionDate;
    private TransactionType transactionType;
    private String narration;
    private Double amount;
    private BigDecimal availableBalance;
    @ManyToOne
    private Account account;
}
