package Controller;

import Entity.Profile;
import Model.UserDAO;
import Model.UserDAOimpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignIn", value = "/SignIn")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDAO user = new UserDAOimpl();
        Profile profile = user.login(login, password);
        if (profile != null) {
            request.getSession().setAttribute("logged", true);
            request.getSession().setAttribute("userData", profile);
        }else response.sendError(404, "Wrong Username or Password");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
