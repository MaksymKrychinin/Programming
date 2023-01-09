package com.example.autoRent.Controller.AdminControllers;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.Factory.AdminDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UnbanUser", value = "/UnbanUser")
public class UnbanUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        AdminDAO adminDAO = AdminDAOFactory.getInstance();
        boolean status = adminDAO.unbanUser(idUser);
        if (status){
            response.sendRedirect("components/admin/carsList.jsp");
        }else
        response.sendRedirect("error.jsp");
    }
}
