package ru.itis.dis.lab06;

import java.sql.*;

public class DbStatementInsertInto2Tables {


    public static void main(String[] args) {
        try {
            // Загружаем драйвер
            Class.forName("org.postgresql.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            // адрес БД , имя пользователя, пароль
                            "jdbc:postgresql://localhost:5432/bankdb","postgres","passwd");

            Statement statement = connection.createStatement();

            // Вариант 1
            boolean result = statement.execute(
                    "insert into bank (bik, name) values ('7','bank7') returning id");

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            Integer bankId = resultSet.getInt("id");
            resultSet.close();

            statement.execute(
                "insert into client (passport, bank_id) values ('2222'," + bankId + ")");

            // Вариант 2
            result = statement.execute(
                    "select * from nextval('bank_seq')");

            resultSet = statement.getResultSet();
            resultSet.next();
            bankId = resultSet.getInt("nextval");
            resultSet.close();

            result = statement.execute(
                    "insert into bank (id,bik, name) values (" + bankId + ",'8','bank8')");


            statement.execute(
                    "insert into client (passport, bank_id) values ('3333'," + bankId + ")");

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
