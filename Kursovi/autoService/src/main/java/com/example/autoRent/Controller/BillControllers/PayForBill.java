package com.example.autoRent.Controller.BillControllers;

import com.example.autoRent.Model.DAO.BillDAO;
import com.example.autoRent.Model.Factory.BillDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PayForBill", value = "/PayForBill")
public class PayForBill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBill = Integer.parseInt(request.getParameter("idBill"));
        BillDAO billDAO = BillDAOFactory.getInstance();
        billDAO.changeBillPaymentStatus(idBill);
        response.sendRedirect("/UserBills");
    }
}
