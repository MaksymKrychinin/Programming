package com.example.lab2ee;

import ClassPackage.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculate", value = "/Calculate")
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Param param = new Param(request, response);
        double result = 0;
        try {
            result=new Formules().y(param);
        }catch (ArithmeticException e){
            response.sendError(412, e.getMessage());
        }
        addCookie("a", param.getA(), response);
        addCookie("b", param.getB(), response);
        addCookie("c", param.getC(), response);
        addCookie("d", param.getD(), response);
        addCookie("result", result, response);

        response.sendRedirect("/index.jsp");
    }
    protected void addCookie(String name,double param, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie(name,String.valueOf(param));
        cookie.setMaxAge(new ConfigReader().getPropValues("age"));
        response.addCookie(cookie);
    }
}


