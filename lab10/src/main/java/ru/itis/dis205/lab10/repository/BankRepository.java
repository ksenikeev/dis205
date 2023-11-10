package ru.itis.dis205.lab10.repository;

import ru.itis.dis205.lab10.model.Bank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankRepository {

    public List<Bank> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select name, bik from bank"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Bank> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Bank(
                        resultSet.getString("name"),
                        resultSet.getString("bik")));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
