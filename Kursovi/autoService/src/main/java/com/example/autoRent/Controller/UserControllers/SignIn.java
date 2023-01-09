package com.example.autoRent.Controller.UserControllers;

import com.example.autoRent.Model.DAO.UserDAO;
import com.example.autoRent.Model.Entity.User;
import com.example.autoRent.Model.Factory.UserDAOFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignIn", value = "/SignIn")
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO userDAO = UserDAOFactory.getInstance();
        User user = userDAO.signIn(email, password);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("index.jsp");
    }
}
