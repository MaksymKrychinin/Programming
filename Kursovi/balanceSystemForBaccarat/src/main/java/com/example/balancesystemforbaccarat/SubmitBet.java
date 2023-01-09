package com.example.balancesystemforbaccarat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SubmitBet", value = "/SubmitBet")
public class SubmitBet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int redBet, tieBet, blueBet;
        int betSum = 0;
        User user = (User) request.getSession().getAttribute("user");
        BetClass betClass = BetClass.getInstance();
        int indexOfUser = betClass.list.indexOf(user);
        User userFromList = betClass.list.get(indexOfUser);
        if (request.getParameter("red") != null && !request.getParameter("red").isEmpty()) {
            redBet = Integer.parseInt(request.getParameter("red"));
            userFromList.red += redBet;
            betSum += redBet;
        }
        if (request.getParameter("tie") != null && !request.getParameter("tie").isEmpty()) {
            tieBet = Integer.parseInt(request.getParameter("tie"));
            userFromList.tie += tieBet;
            betSum += tieBet;
        }
        if (request.getParameter("blue") != null && !request.getParameter("blue").isEmpty()) {
            blueBet = Integer.parseInt(request.getParameter("blue"));
            userFromList.blue += blueBet;
            betSum += blueBet;
        }
        userFromList.balance-=betSum;
        request.getSession().setAttribute("user", userFromList);
        response.sendRedirect("/");
    }
}
