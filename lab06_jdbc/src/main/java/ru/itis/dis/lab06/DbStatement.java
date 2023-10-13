package ru.itis.dis.lab06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbStatement {


    public static void main(String[] args) {
        try {
            // Загружаем драйвер
            Class.forName("org.postgresql.Driver");

            Connection connection =
                    DriverManager.getConnection(
                            // адрес БД , имя пользователя, пароль
                            "jdbc:postgresql://localhost:5432/bankdb","postgres","passwd");

            Statement statement = connection.createStatement();

            boolean result = statement.execute("create table test1 (id serial primary key)");

            System.out.println("result = " + result);

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
