package com.example.lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontController", value = "/FrontController")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "";
        switch (request.getParameter("conf")){
            case "GetMarket":
                path = "/market";
                break;
            case "goodsSearch":
                path = "/good";
                break;
            case "GetMarkets":
                path = "/markets";
                break;
            case "PriceLowest":
                path = "/price";
                break;
            default:
                response.sendError(404,"Illegal link");
        }

        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorText", ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/errorPage.jsp");
            rd.forward(request,response);
        }
    } 
}
