package com.example.db;

import com.example.config.AppConfig;
import org.flywaydb.core.Flyway;

public class MigrationConfig {

    public static void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource(AppConfig.getDataSource()) 
                .locations("classpath:db/migration")  
                .load();

        flyway.migrate();
    }
}
