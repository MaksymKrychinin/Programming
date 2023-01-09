package com.example.autoRent.Controller.AdminControllers;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Factory.AdminDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllCars", value = "/GetAllCars")
public class GetAllCars extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO adminDAO = AdminDAOFactory.getInstance();
        List<Car> carsList = adminDAO.getAllCars();
        request.setAttribute("carsList", carsList);
        request.getRequestDispatcher("components/admin/carsList.jsp").forward(request, response);
    }
}
