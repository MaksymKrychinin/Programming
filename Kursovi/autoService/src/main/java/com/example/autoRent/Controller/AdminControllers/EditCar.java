package com.example.autoRent.Controller.AdminControllers;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Factory.AdminDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditCar", value = "/EditCar")
public class EditCar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCar = Integer.parseInt(request.getParameter("idCar"));
        String name = request.getParameter("name");
        String qualityClass = request.getParameter("qualityClass");
        double costPerHour = Double.parseDouble(request.getParameter("costPerHour"));
        String brand = request.getParameter("brand");
        Car car = new Car(idCar, name, qualityClass, costPerHour, brand);
        AdminDAO adminDAO = AdminDAOFactory.getInstance();
        boolean status = adminDAO.editCar(car);
        if (status){
            response.sendRedirect("components/admin/adminPanel.jsp");
        }else
        response.sendRedirect("error.jsp");
    }
}
