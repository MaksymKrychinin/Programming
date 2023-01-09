package com.example.autoRent.Controller.BillControllers;

import com.example.autoRent.Model.DAO.BillDAO;
import com.example.autoRent.Model.Entity.Bill;
import com.example.autoRent.Model.Entity.Car;
import com.example.autoRent.Model.Entity.User;
import com.example.autoRent.Model.Factory.BillDAOFactory;
import com.example.autoRent.Model.Factory.CarDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RentCar", value = "/RentCar")
public class RentCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iduser = ((User)request.getSession().getAttribute("user")).getIduser();
        int idCar = Integer.parseInt(request.getParameter("idCar"));
        String frontPassport=request.getParameter("frontPassport");
        String backPassport=request.getParameter("backPassport");
        boolean driver=request.getParameter("driver").equals("yes");
        int rentTime = Integer.parseInt(request.getParameter("rentTime"));
        Car car = CarDAOFactory.getInstance().getCarById(idCar);
        double cost = (car.getCostPerHour()+(driver?100:0))*rentTime;
        Bill bill = new Bill(iduser, idCar, frontPassport, backPassport, driver, rentTime, cost);
        BillDAO billDAO = BillDAOFactory.getInstance();
        billDAO.createBill(bill);
        response.sendRedirect("index.jsp");
    }
}
