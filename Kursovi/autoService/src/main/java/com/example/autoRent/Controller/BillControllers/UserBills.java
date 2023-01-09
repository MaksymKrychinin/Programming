package com.example.autoRent.Controller.BillControllers;

import com.example.autoRent.Model.DAO.BillDAO;
import com.example.autoRent.Model.Entity.Bill;
import com.example.autoRent.Model.Entity.User;
import com.example.autoRent.Model.Factory.BillDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserBills", value = "/UserBills")
public class UserBills extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        BillDAO billDAO = BillDAOFactory.getInstance();
        List<Bill> billsList = billDAO.allUserBills(user);
        request.setAttribute("billsList", billsList);
        request.getRequestDispatcher("components/user/userBills.jsp").forward(request, response);
    }
}
