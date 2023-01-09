package com.lab4EE.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FrontController", value = "/FrontController")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "";
        switch (request.getParameter("conf")){
            case "minimumPriceFromName":
                path = "/minimumPriceFromNameServlet";
                break;
            case "listOfMarketsWhereItemPriceIsMinimum":
                path = "/listOfMarketsWhereItemPriceIsMinimumServlet";
                break;
            case "theCheapestShop":
                path = "/theCheapestShopServlet";
                break;
            default:
                response.sendError(404,"Illegal link");
        }

        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorText", ex.getMessage());
            ex.printStackTrace();
        }
    } 
}
