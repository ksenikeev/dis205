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
import java.util.Map;

@Component
public class EntityManagerImpl implements EntityManager {

    @Autowired
    private DataSource dataSource;

    private Map<String, Object> entityes;


    /*
        1. Создаем подключение к БД (JDBC Connection)
        2. Сканируем структуру классов
        3. Запрашиваем структуру БД
        4. Проверяем соответствие объектная модели - реляционная модель:
        нашли класс - наличие таблицы
        нашли поле - наличие поля в таблице
     */



    @Override
    public <T> T save(T entity) {
        return null;
    }

    @Override
    public void remove(Object entity) {

    }

    @Override
    public <T> T find(Class<T> entityType, Object key) {
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityType) {
        String sql = "select * from " + entityType.getSimpleName().toLowerCase();
        List<T> result = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                //T track = new T();
                // перебираем поля класса и вытаскиваем значения по имени поля из resultSet
                //track.setId(resultSet.getInt("id"));
                //track.setName(resultSet.getString("name"));
                //result.add(track);
            }

            resultSet.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
