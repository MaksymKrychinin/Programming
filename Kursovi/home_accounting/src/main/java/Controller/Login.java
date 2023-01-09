package Controller;

import Model.DAO.Auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
        Auth account = new Auth();
        int idUser = account.login(login, password);
        if (idUser == 0) {
            request.setAttribute("error", "Помилка, ввідіть в аккаунт");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("idUser", idUser);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
