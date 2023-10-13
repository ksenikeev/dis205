package ru.itis.dis.lab06;

import java.sql.*;

public class DbStatementSelect {


    public static void main(String[] args) {
        try {
            // Загружаем драйвер
            Class.forName("org.postgresql.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            // адрес БД , имя пользователя, пароль
                            "jdbc:postgresql://localhost:5432/bankdb","postgres","passwd");

            Statement statement = connection.createStatement();

            boolean result = statement.execute(
                    "SELECT * FROM bank");

            System.out.println("result = " + result);

            if (result) {
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("bik"));
                    System.out.println(resultSet.getString("name"));
                }

                resultSet.close();
            }

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
