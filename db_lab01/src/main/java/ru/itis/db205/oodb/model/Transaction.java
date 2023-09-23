package ru.itis.db205.oodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class Transaction {
    private Account sourceAccount;
    private Account destAccount;
    private Float sum;
    private Date transactionDate;

    public Transaction(Account sourceAccount, Account destAccount, Float sum, Date transactionDate) {
        this.sourceAccount = sourceAccount;
        sourceAccount.setBalance(sourceAccount.getBalance() - sum);
        this.destAccount = destAccount;
        destAccount.setBalance(destAccount.getBalance() + sum);
        this.sum = sum;
        this.transactionDate = transactionDate;
    }
}
