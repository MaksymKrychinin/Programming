package com.example.lilya_kyrsova;

import DB.ExchangeDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "changeRate", value = "/changeRate")
public class changeRate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isAdmin = (boolean) request.getSession().getAttribute("admin");
        if (isAdmin) {
            String nameOfCurrencyToSetDate = request.getParameter("nameOfCurrencyToSetDate");
            String dateToSetRate = request.getParameter("dateToSetRate");
            double sellRateToSet = Double.parseDouble(request.getParameter("sellRateToSet"));
            double buyRateToSet = Double.parseDouble(request.getParameter("buyRateToSet"));
            ExchangeDB.addRate(nameOfCurrencyToSetDate, Date.valueOf(dateToSetRate), sellRateToSet, buyRateToSet);

            request.setAttribute("status", "Successfully added new rate for " +
                    nameOfCurrencyToSetDate + " at " + dateToSetRate + " with sell/buy rate: " +
                    sellRateToSet + " " + buyRateToSet);
        }
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
