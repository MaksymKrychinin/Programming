package Servlets;

import Model.DAO.Auth;

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
        Auth account = new Auth();
        account.login(login, password);
        int idUser = account.getIdUser();
        int idPermission = account.getUserPermission();
        if (idUser == -1 | idPermission==-1) {
            request.setAttribute("error", "Error");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("idUser", idUser);
            request.getSession().setAttribute("userPermission", idPermission);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
