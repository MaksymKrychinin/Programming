package com.example.autoRent.Controller.Manager;

import com.example.autoRent.Model.DAO.BillDAO;
import com.example.autoRent.Model.Entity.Bill;
import com.example.autoRent.Model.Entity.User;
import com.example.autoRent.Model.Factory.BillDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllBillsWithStatusInRent", value = "/AllBillsWithStatusInRent")
public class AllBillsWithStatusInRent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillDAO billDAO = BillDAOFactory.getInstance();
        List<Bill> billsList = billDAO.allBillsWithStatusInRent();
        request.setAttribute("billsList", billsList);
        request.getRequestDispatcher("components/manager/billsList.jsp").forward(request, response);
    }
}
