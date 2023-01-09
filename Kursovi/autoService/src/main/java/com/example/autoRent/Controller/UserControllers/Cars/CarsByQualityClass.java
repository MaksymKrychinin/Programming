package com.example.autoRent.Controller.UserControllers.Cars;

import com.example.autoRent.Model.DAO.CarDAO;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Factory.CarDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CarsByQualityClass", value = "/CarsByQualityClass")
public class CarsByQualityClass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qualityClass = request.getParameter("qualityClass");
        CarDAO carDAO = CarDAOFactory.getInstance();
        List<Car> carsList = carDAO.carsByClass(qualityClass);
        request.setAttribute("carsList", carsList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
