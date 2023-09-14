package ru.itis.db205.oodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter@AllArgsConstructor
public class Transaction {
    private Account sourceAccount;
    private Account destAccount;
    private Float sum;
    private Date transactionDate;
}
