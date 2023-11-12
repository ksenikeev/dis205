package ru.itis.dis205.lab10.repository;

import ru.itis.dis205.lab10.model.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public List<Client> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name, username,password, phonenumber from client"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Client> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phonenumber")
                        ));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client findById(Long id) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                "select id,name, username,password, phonenumber from client where id = ? "
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            Client result = null;

            if (resultSet.next()) {
                result = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phonenumber")
                );
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client findByUserName(String userName) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name, username,password, phonenumber from client where username = ? "
            );

            statement.setString(1, userName);

            ResultSet resultSet = statement.executeQuery();

            Client result = null;

            if (resultSet.next()) {
                result = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phonenumber")
                );
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
