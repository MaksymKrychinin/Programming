package Controller;

import Model.Account;

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
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        Account account = new Account();
        boolean status = account.register(username, login, password);
        if (status) {
            int idCurrentUser = account.signIn(login,password);
            request.getSession().setAttribute("idCurrentUser", idCurrentUser);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("status", "Error, wrong login or pass");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
