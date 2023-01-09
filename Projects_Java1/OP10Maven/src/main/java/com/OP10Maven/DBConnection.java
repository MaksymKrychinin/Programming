package com.OP10Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String HOST = "jdbc:mysql://127.0.0.1:3306/items";
    private static final String USER = "root";
    private static final String PASSWORD = "mak7.0202";
    private Connection connection = null;

    DBConnection() {
        try {
            connection = DriverManager.getConnection(HOST, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
