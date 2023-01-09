package com.lab4EE.Model;

import com.lab4EE.DAOimpl.ServiceDAO;
import com.lab4EE.Model.Entities.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "theCheapestShopServlet", value = "/theCheapestShopServlet")
public class theCheapestShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceDAO serviceDAO = new ServiceDAO();
        Service isMarketWithPriceLowerThanStock = serviceDAO.isMarketWithPriceLowerThanStock();
        request.setAttribute("isMarketWithPriceLowerThanStock", isMarketWithPriceLowerThanStock);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
