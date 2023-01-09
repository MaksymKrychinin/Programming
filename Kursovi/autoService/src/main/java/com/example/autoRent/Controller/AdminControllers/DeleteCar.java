package com.example.autoRent.Controller.AdminControllers;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.Factory.AdminDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCar", value = "/DeleteCar")
public class DeleteCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCar = Integer.parseInt(request.getParameter("idCar"));
        AdminDAO adminDAO = AdminDAOFactory.getInstance();
        boolean status = adminDAO.deleteCar(idCar);
        if (status){
            response.sendRedirect("components/admin/adminPanel.jsp");
        }else
        response.sendRedirect("error.jsp");
    }
}
