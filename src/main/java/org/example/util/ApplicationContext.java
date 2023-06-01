package org.example.util;

import java.sql.Connection;

public class ApplicationContext {
    static private Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            connection = new DatabaseConnector().getDatabaseConnection();
            return connection;
        }
    }
}
