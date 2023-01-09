package ClassPackage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Param {
    double a;
    double b;
    double c;
    double d;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public Param(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            this.a = Double.parseDouble(request.getParameter("a"));
            this.b = Double.parseDouble(request.getParameter("b"));
            this.c = Double.parseDouble(request.getParameter("c"));
            this.d = Double.parseDouble(request.getParameter("d"));

        } catch (NumberFormatException nfe) {
             response.sendError(412);
        }

    }
}
