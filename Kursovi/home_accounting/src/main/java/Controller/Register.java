package Controller;


import Model.DAO.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        Auth account = new Auth();
        boolean status = account.register(login, password);
        if (status) {
            int idUser = account.login(login,password);
            request.getSession().setAttribute("idUser", idUser);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Помилка, ввідіть в аккаунт");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
