package com.example.autoRent.Controller.UserControllers.Cars;

import com.example.autoRent.Model.DAO.CarDAO;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Factory.CarDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarById", value = "/CarById")
public class CarById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCar = Integer.parseInt(request.getParameter("idCar"));
        CarDAO carDAO = CarDAOFactory.getInstance();
        Car car = carDAO.getCarById(idCar);
        request.setAttribute("car", car);
        request.getRequestDispatcher("components/user/carRentForm.jsp").forward(request, response);
    }
}
