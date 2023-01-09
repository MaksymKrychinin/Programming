package com.example.lab1;

import DB.DAO;
import DB.UserCommands;

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
        DAO userCommands = new UserCommands();
            if (userCommands.currentUser(login, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("login", login);
                request.getRequestDispatcher("/userGeneration.jsp").forward(request,response);
            } else {
                response.sendRedirect("/userNotFound.html");
        }
    }
}
