package com.example.lilya_kyrsova;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "isAdmin", value = "/isAdmin")
public class IsAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdminAccount account = new AdminAccount();
        if (account.isAdmin(request)){
            request.getSession().setAttribute("admin", true);
        } else request.getSession().setAttribute("admin", false);
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
