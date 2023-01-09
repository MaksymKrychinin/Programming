package com.example.autoRent.Controller.AdminControllers;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Entity.User;
import com.example.autoRent.Model.Factory.AdminDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllUsers", value = "/GetAllUsers")
public class GetAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO adminDAO = AdminDAOFactory.getInstance();
        List<User> usersList = adminDAO.getAllUsers();
        request.setAttribute("usersList", usersList);
        request.getRequestDispatcher("components/admin/usersList.jsp").forward(request, response);
    }
}
