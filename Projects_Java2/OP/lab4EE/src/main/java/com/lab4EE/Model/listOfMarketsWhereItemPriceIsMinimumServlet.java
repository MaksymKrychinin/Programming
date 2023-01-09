package com.lab4EE.Model;

import com.lab4EE.DAOimpl.MarketDAO;
import com.lab4EE.Model.Entities.Market;
import com.lab4EE.Model.Entities.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listOfMarketsWhereItemPriceIsMinimumServlet", value = "/listOfMarketsWhereItemPriceIsMinimumServlet")
public class listOfMarketsWhereItemPriceIsMinimumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("second");
        MarketDAO marketDAO = new MarketDAO();
        Service service = marketDAO.findMarketsMinItemPrice(itemName);
        request.setAttribute("markets", service);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
