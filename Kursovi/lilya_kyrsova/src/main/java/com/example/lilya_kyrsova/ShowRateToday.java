package com.example.lilya_kyrsova;

import DB.ExchangeDB;
import Entity.ExchangeRate;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowRateToday", value = "/ShowRateToday")
public class ShowRateToday extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExchangeRate exchange = ExchangeDB.tableAllRateToday();
        request.setAttribute("tableAllRateToday", exchange);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
