package com.example.autoRent.Controller.AdminControllers;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Factory.AdminDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCar", value = "/AddCar")
public class AddCar extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String qualityClass = request.getParameter("qualityClass");
        double costPerHour = Double.parseDouble(request.getParameter("costPerHour"));
        String brand = request.getParameter("brand");
        Car car = new Car(name, qualityClass, costPerHour, brand);
        AdminDAO adminDAO = AdminDAOFactory.getInstance();
        boolean status = adminDAO.addCar(car);
        if (status) {
            response.sendRedirect("components/admin/addCarForm.jsp");
        } else{
            request.setAttribute("errorMassage", "You can't add this car, qualityClass has edited");
            response.sendRedirect("error.jsp");}
    }
}
