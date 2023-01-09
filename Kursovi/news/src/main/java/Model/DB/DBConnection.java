package Model.DB;

import Config.ConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements AutoCloseable{
    static ConfigReader configReader = new ConfigReader();
    private static final String HOST = configReader.getProperty("HOST");
    private static final String USER = configReader.getProperty("USER");
    private static final String PASSWORD = configReader.getProperty("PASSWORD");
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
