package kursova_libruary;

import db.Admin;

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
        Admin admin = new Admin();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (admin.isAdmin(login, password)){
            request.getSession().setAttribute("admin", true);
        } else request.getSession().setAttribute("admin", false);
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
