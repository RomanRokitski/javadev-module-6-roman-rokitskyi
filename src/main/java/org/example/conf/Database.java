package org.example.databaseUtils;

import org.example.conf.FlywayConfigurations;import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String FLYWAY_CONNECTION_URL = "jdbc:h2:~/H2/homework3";
    private static final String FLYWAY_USER = "roman";
    private static final String FLYWAY_PASSWORD = "123";
    private final Connection connection;

    public Database() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(FLYWAY_CONNECTION_URL, FLYWAY_USER, FLYWAY_PASSWORD);
    }

    public static FlywayConfigurations.Database getInstance() {
        try {
            return new FlywayConfigurations.Database();
        } catch (Exception e) {
            throw new RuntimeException("Instantiation od Database failed", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
