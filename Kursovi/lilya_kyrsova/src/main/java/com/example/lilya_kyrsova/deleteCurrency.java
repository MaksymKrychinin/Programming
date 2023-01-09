package com.example.lilya_kyrsova;

import DB.CurrencyDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteCurrency", value = "/deleteCurrency")
public class deleteCurrency extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isAdmin = (boolean) request.getSession().getAttribute("admin");
        if (isAdmin) {
            String name = request.getParameter("nameOfCurrencyDelete");
            CurrencyDB.deleteCurrency(name);
            request.setAttribute("status", "Successfully deleted currency: " + name);
        }
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
