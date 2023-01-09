package com.example.projectmanagment;

import DAO.UserDAO;
import Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignIn", value = "/SignIn")
public class SignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User(login, password);
        UserDAO userDAO = new UserDAO();
        user = userDAO.signIn(user);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("index.jsp");
    }
}
