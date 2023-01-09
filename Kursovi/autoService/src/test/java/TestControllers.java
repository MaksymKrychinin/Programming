
import com.example.autoRent.Controller.AdminControllers.AddCar;
import com.example.autoRent.Model.DataBaseConnectionPool.ConnectionPool;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DatasourceTest {
    @Mock
    private DataSource datasource;


    @org.junit.jupiter.api.Test
    void insertTable() throws SQLException {
        assertNull(datasource);

    }

}
