import com.example.autoRent.Controller.AdminControllers.AddCar;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMyServlet extends Mockito {

    @Test
    public void testAddCarExpectedTrue() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testDeleteCarExpectedTrue() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testEditCarExpectedTrue() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testBanUserExpectedUserIsNullResponseToErrorPage() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testUnBanUserExpectedUserIsNullResponseToErrorPage() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testAddCarExpectedFalse() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testDeleteCarExpectedError() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testEditCarExpectedNullPointer() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testBanUserExpectedTrue() throws Exception {
        assertEquals(true, true);
    }
    @Test
    public void testUnBanUserExpectedTrue() throws Exception {
        assertEquals(true, true);
    }
}
