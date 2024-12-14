package com.example.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.hibernate.cfg.Configuration;

import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class AppConfig {

    private static final Config config = ConfigFactory.load();

    public static DataSource getDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(config.getString("db.url"));
        dataSource.setUser(config.getString("db.user"));
        dataSource.setPassword(config.getString("db.password"));
        return dataSource;
    }

   
    public static Configuration getHibernateConfiguration() {
        Configuration hibernateConfig = new Configuration();
        hibernateConfig.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateConfig.setProperty("hibernate.connection.driver_class", config.getString("db.driver"));
        hibernateConfig.setProperty("hibernate.connection.url", config.getString("db.url"));
        hibernateConfig.setProperty("hibernate.connection.username", config.getString("db.user"));
        hibernateConfig.setProperty("hibernate.connection.password", config.getString("db.password"));
        hibernateConfig.setProperty("hibernate.hbm2ddl.auto", "validate"); 
        hibernateConfig.setProperty("hibernate.show_sql", "true");
        hibernateConfig.setProperty("hibernate.format_sql", "true");
        return hibernateConfig;
    }
}
