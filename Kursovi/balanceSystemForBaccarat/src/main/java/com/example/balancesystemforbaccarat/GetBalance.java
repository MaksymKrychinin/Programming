package com.example.balancesystemforbaccarat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetBalance", value = "/GetBalance")
public class GetBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        BetClass betClass = BetClass.getInstance();
        int indexOfUser = betClass.list.indexOf(user);
        User userFromList = betClass.list.get(indexOfUser);
        request.getSession().setAttribute("user", userFromList);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
