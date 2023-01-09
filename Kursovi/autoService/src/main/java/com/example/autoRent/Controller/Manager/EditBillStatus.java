package com.example.autoRent.Controller.Manager;

import com.example.autoRent.Model.DAO.BillDAO;
import com.example.autoRent.Model.Factory.BillDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditBillStatus", value = "/EditBillStatus")
public class EditBillStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idBill = Integer.parseInt(request.getParameter("idBill"));
        String status = request.getParameter("status");
        if (status==null||status.isEmpty()){
            status="Accepted";
        }
        BillDAO billDAO = BillDAOFactory.getInstance();
        billDAO.editBillStatus(idBill, status);
        response.sendRedirect("/AllBillsWithStatusInRent");
    }
}
