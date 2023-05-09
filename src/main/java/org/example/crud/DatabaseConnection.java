package org.example.crud;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String H2_URL = "jdbc:h2:~/H2/homework3";
    private static final String USERNAME = "roman";
    private static final String PASSWORD = "123";
    private final Connection connection;

    public DatabaseConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(H2_URL, USERNAME, PASSWORD);
    }

    public static DatabaseConnection getInstance() {
        try {
            return new DatabaseConnection();
        } catch (Exception e) {
            throw new RuntimeException("Instantiation od DatabaseConnection failed", e);
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
