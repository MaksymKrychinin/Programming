package DataBaseConnectionPool;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {


    private ConnectionPool() {
    }

    private static DataSource dataSource;

    public static synchronized DataSource getDataSource() {
        if (dataSource == null) {
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/ConnectionPool");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

}
