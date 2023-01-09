package com.example.lilya_kyrsova;

import DB.CurrencyDB;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addNewCurrency", value = "/addNewCurrency")
public class addNewCurrency extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isAdmin = (boolean) request.getSession().getAttribute("admin");
        if (isAdmin) {
            String name = request.getParameter("addForName");
            CurrencyDB.addNewCurrency(name);
            request.setAttribute("status", "Successfully added new currency: " + name);
        }
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
