package Servlets;

import db.signIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        signIn signIn = new signIn();
        String role = signIn.roleOfUser(login, password);
        if (role != null) {
            request.getSession().setAttribute("role", role);
            request.getSession().setAttribute("logged", true);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "BAD LOGIN");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
