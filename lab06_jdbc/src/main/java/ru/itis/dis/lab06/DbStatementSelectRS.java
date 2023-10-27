package ru.itis.dis.lab06;

import java.sql.*;

public class DbStatementSelectRS {


    public static void main(String[] args) {
        try {
            // Загружаем драйвер
            Class.forName("org.postgresql.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            // адрес БД , имя пользователя, пароль
                            "jdbc:postgresql://localhost:5432/bankdb","postgres","passwd");

            int id = 41;

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM bank where id= ? ");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("bik"));
                System.out.println(resultSet.getString("name"));
            }

            resultSet.close();

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
