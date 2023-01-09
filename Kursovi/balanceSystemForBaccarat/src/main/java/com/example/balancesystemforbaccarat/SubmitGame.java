package com.example.balancesystemforbaccarat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.function.Consumer;

@WebServlet(name = "SubmitGame", value = "/SubmitGame")
public class SubmitGame extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BetClass betClass = BetClass.getInstance();
        String color = request.getParameter("winColor");
        if (color.equals("blue")){
            betClass.list.forEach(user -> user.winBlue());
        }
        if (color.equals("tie")){
            betClass.list.forEach(user -> user.winTie());
        }
        if (color.equals("red")){
            betClass.list.forEach(user -> user.winRed());
        }
        response.sendRedirect("adminPanel.jsp");
    }
}
