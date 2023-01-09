package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements AutoCloseable {
    private static final String HOST = "jdbc:mysql://127.0.0.1:3306/users";
    private static final String USER = "root";
    private static final String PASSWORD = "mak7.0202";
    private Connection connection = null;

    DBConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
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
