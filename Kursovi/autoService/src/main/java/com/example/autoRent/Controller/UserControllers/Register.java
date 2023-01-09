package com.example.autoRent.Controller.UserControllers;

import com.example.autoRent.Model.DAO.UserDAO;
import com.example.autoRent.Model.Entity.User;
import com.example.autoRent.Model.Factory.UserDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname= request.getParameter("surname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        Date dateOfBirthday = Date.valueOf(request.getParameter("date"));
        User user = new User(name, surname, gender, email, password, phoneNumber, dateOfBirthday);
        UserDAO userDAO = UserDAOFactory.getInstance();
        User userAfterRegister = userDAO.register(user);
        request.getSession().setAttribute("user", userAfterRegister);
        response.sendRedirect("index.jsp");
    }
}
