package org.example;

import java.sql.SQLException;


public class App {
    public static void main(String[] args) throws SQLException {
        while(!Menu.stop) {
            Menu.menu();
        }
    }
}
