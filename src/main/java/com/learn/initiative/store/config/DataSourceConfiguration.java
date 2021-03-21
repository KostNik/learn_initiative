package com.learn.initiative.store.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class DataSourceConfiguration {

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return Flyway::migrate;
    }

}
