package ru.itis.dis205.lab2_5.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.dis205.lab2_5.model.MusicTrack;
import ru.itis.dis205.lab2_5.orm.EntityManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MisicRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManager entityManager;


    public void printAllTracks() {
        String sql = "select * from musictrack";

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            resultSet.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<MusicTrack> findAllTracks() {
        String sql = "select * from musictrack";
        List<MusicTrack> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                MusicTrack track = new MusicTrack();
                track.setId(resultSet.getInt("id"));
                track.setName(resultSet.getString("name"));
                result.add(track);
            }

            resultSet.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<MusicTrack> findAllTracksByEntityManager() {
        return entityManager.findAll(MusicTrack.class);
    }

}
