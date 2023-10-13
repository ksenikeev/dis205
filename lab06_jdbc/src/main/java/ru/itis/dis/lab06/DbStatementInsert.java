package ru.itis.dis.lab06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbStatementInsert {


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
                    "insert into bank values ('1','bank1'),('2','bank2')");

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
