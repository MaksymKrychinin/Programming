package com.example.lab2ee;

import ClassPackage.ConfigReader;

import javax.servlet.*;
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
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        double d = Double.parseDouble(request.getParameter("d"));
        if (a == 0) {
            response.sendError(412, "a=0");
        } else if (b == 0) {
            response.sendError(412, "b=0");
        } else {
            try (PrintWriter pw = response.getWriter()) {
                pw.println(3 * (Math.log(Math.abs(b / a)) + Math.sqrt(Math.sin(c) + Math.pow(Math.E, d))));
            }
            addCookie("a", a, response);
            addCookie("b", b, response);
            addCookie("c", c, response);
            addCookie("d", d, response);

        }
    }

    protected void addCookie(String name, double param, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie(name, String.valueOf(param));
        cookie.setMaxAge(new ConfigReader().getPropValues("age"));
        response.addCookie(cookie);
    }
}


