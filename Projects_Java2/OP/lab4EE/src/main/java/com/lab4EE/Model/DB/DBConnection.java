package com.lab4EE.Model.DB;

import com.lab4EE.Config.ConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements AutoCloseable{
    static ConfigReader configReader = new ConfigReader();
    private static final String HOST = configReader.getPropValues("HOST");
    private static final String USER = configReader.getPropValues("USER");
    private static final String PASSWORD = configReader.getPropValues("PASSWORD");
    private Connection connection = null;

    public DBConnection() {
        try {
            connection = DriverManager.getConnection(HOST, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }


    @Override
    public void close() throws Exception {
        connection.close();
    }
}
