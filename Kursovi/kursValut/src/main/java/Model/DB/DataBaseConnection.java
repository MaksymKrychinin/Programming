package Model.DB;

import Model.Config.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection implements AutoCloseable{
    static PropertiesReader configPropertiesReader = new PropertiesReader();
    private static final String host = configPropertiesReader.getProperty("host");
    private static final String user = configPropertiesReader.getProperty("user");
    private static final String pass = configPropertiesReader.getProperty("pass");
    private Connection connection = null;

    public DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(host, user, pass);
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
