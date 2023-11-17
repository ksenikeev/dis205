package ru.itis.dis205.lab10.repository;

import ru.itis.dis205.lab10.model.Client;
import ru.itis.dis205.lab10.model.Merch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MerchRepository {

    public List<Merch> findAll() {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select id,name, articul,price from merch"
            );

            ResultSet resultSet = statement.executeQuery();

            List<Merch> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Merch(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("articul"),
                        resultSet.getDouble("price")
                ));
            }

            resultSet.close();
            statement.close();

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

