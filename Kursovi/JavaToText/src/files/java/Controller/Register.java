package Controller;

import Model.UserDAO;
import Model.UserDAOimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String openInfo = request.getParameter("openInfo");
        String privateInfo = request.getParameter("privateInfo");
        UserDAO profile = new UserDAOimpl();
        if (profile.accountExist(login, password)==false) {
            profile.register(username, login, password, openInfo, privateInfo);
            request.getSession().setAttribute("logged", true);
            request.getSession().setAttribute("active", 1);
            request.getSession().setAttribute("userData", profile.login(login, password));
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
