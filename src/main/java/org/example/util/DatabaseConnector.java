package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    static final String USERNAME = "postgres";
    static final String PASSWORD = "postgrepass";
    static final String URL = "jdbc:postgresql://localhost:5432/hw7";

    public Connection getDatabaseConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("connection created");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}