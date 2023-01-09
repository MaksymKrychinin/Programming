package com.example.lilya_kyrsova;

import DB.CurrencyDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "editCurrency", value = "/editCurrency")
public class editCurrency extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isAdmin = (boolean) request.getSession().getAttribute("admin");
        if (isAdmin) {
            String nameOfCurrencyForEdit = request.getParameter("nameOfCurrencyForEdit");
            String nameAfterEdit = request.getParameter("nameAfterEdit");
            CurrencyDB.renameCurrency(nameOfCurrencyForEdit, nameAfterEdit);
            request.setAttribute("status", "Successfully edited " + nameOfCurrencyForEdit +
                    " to " + nameAfterEdit);
        }
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
