package com.example.autoRent.Controller.AdminControllers;

import com.example.autoRent.Model.DAO.AdminDAO;
import com.example.autoRent.Model.Entity.User;
import com.example.autoRent.Model.Factory.AdminDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddManager", value = "/AddManager")
public class AddManager extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname= request.getParameter("surname");
        String gender= request.getParameter("gender");
        String email= request.getParameter("email");
        String password= request.getParameter("password");
        String phoneNumber= request.getParameter("phoneNumber");
        Date dateOfBirthday= Date.valueOf(request.getParameter("dateOfBirthday"));
        User user = new User(name, surname, gender, email, password, phoneNumber, dateOfBirthday);
        AdminDAO adminDAO = AdminDAOFactory.getInstance();
        boolean status = adminDAO.addManager(user);
        if (status){
            response.sendRedirect("components/admin/adminPanel.jsp");
        }else
        response.sendRedirect("error.jsp");
    }
}
