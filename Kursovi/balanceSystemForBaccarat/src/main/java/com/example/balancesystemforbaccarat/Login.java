package com.example.balancesystemforbaccarat;

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
        BetClass betClass = BetClass.getInstance();
        User user = new User(login, 1000);
        betClass.list.add(user);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("index.jsp");
    }
}
