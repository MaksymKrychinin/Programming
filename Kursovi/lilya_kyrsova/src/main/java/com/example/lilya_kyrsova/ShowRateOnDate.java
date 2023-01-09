package com.example.lilya_kyrsova;

import DB.ExchangeDB;
import Entity.ExchangeRate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ShowRateOnDate", value = "/ShowRateOnDate")
public class ShowRateOnDate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Date date1 = Date.valueOf(request.getParameter("date1"));
        Date date2 = Date.valueOf(request.getParameter("date2"));
        ExchangeRate exchange = ExchangeDB.tableCurrecyOfDate(name, date1, date2);
        request.setAttribute("tableCurrencyOfDate", exchange);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
