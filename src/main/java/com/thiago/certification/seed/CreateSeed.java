package com.thiago.certification.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres_certifications");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run(args);
    }

    public void run(String... args) {
       executeSQLFile("src/main/resources/create.sql");
    }

    private void executeSQLFile(String filepath) {
        try {
            String sqlScript = new String(Files.readAllBytes(Paths.get(filepath)));
            jdbcTemplate.execute(sqlScript);

            System.out.println("SQL file executed successfully");
        } catch (IOException e) {
            System.out.println("Error executing SQL file: " + e.getMessage());
        }
    }
}
