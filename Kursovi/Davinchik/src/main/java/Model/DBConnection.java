package Model;

import Config.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements AutoCloseable{
    static Reader configReader = new Reader();
    private static final String HOST = configReader.getProperty("HOST");
    private static final String USER = configReader.getProperty("USER");
    private static final String PASSWORD = configReader.getProperty("PASSWORD");
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


    @Override
    public void close() throws Exception {
        connection.close();
    }
}
