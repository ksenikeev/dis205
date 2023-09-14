package ru.itis.db205.oodb;

import java.io.IOException;
import ru.itis.db205.oodb.json.JsonSaveDB;
import ru.itis.db205.oodb.model.Account;
import ru.itis.db205.oodb.model.Bank;
import ru.itis.db205.oodb.model.Client;
import ru.itis.db205.oodb.model.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Bank bank1 = new Bank();
        bank1.setName("Банк 1");
        bank1.setBik("000001");
        bank1.setCity("Казань");
        bank1.setAddress("Четаева 5");

        Client client1 = new Client("Клиент 1", bank1, "1111");
        Client client2 = new Client("Клиент 2", bank1, "2222");

        Bank bank2 = new Bank();
        bank2.setName("Банк 2");
        bank2.setBik("000002");
        bank2.setCity("Москва");
        bank2.setAddress("Якиманка 5");

        Client client3 = new Client("Клиент 3", bank2,"33333");
        Client client4 = new Client("Клиент 4", bank2,"444444");

        Account account1 = new Account(client1,"RUB", 100000f,"000001");
        Account account2 = new Account(client2,"AUD", 100000f,"000002");
        Account account3 = new Account(client3,"KZT", 100000f,"000003");
        Account account4 = new Account(client4,"UZS", 100000f,"000004");

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(account1,account2,1000f, new Date()));
        transactions.add(new Transaction(account1,account3,1000f, new Date()));
        transactions.add(new Transaction(account1,account4,1000f, new Date()));
        transactions.add(new Transaction(account3,account2,1000f, new Date()));
        transactions.add(new Transaction(account4,account3,1000f, new Date()));

        JsonSaveDB.saveData(transactions);
    }

}
