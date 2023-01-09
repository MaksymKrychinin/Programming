package com.example.lab1;

import DB.DAO;
import DB.UserCommands;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Registration", value = "/Registration")
public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String PIB = request.getParameter("PIB");
        String login = request.getParameter("login");
        String date = request.getParameter("date");
        String password = request.getParameter("password");
        DAO userCommands = new UserCommands();
        if (userCommands.add(PIB, date, password, login)) {
            response.sendRedirect("/login.jsp");
        } else response.sendRedirect("/NotAvailable.jsp");
    }
}
