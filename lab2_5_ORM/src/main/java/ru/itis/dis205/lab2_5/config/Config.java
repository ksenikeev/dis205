package ru.itis.dis205.lab2_5.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

// Описываем контекст через класс-конфигурацию
@Configuration
@ComponentScan("ru.itis.dis205.lab2_5.component")
public class Config {

    @Bean
    public DataSource getDataSource() {
        System.out.println("getDataSource");
        HikariConfig config = new HikariConfig();
        String url = "jdbc:postgresql://localhost:5432/music";
        config.setJdbcUrl(url);
        config.setUsername("postgres");
        config.setPassword("post");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }

    // Автоматическая инициализация
    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setDataSource(dataSource);
        flyway.setTable("rs_schema_version");
        //flyway.setSchemas(SCHEMA);
        return flyway;
    }


}
