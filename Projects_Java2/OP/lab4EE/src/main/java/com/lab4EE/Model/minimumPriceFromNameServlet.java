package com.lab4EE.Model;

import com.lab4EE.DAOimpl.ItemDAO;
import com.lab4EE.Model.Entities.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "minimumPriceFromNameServlet", value = "/minimumPriceFromNameServlet")
public class minimumPriceFromNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemDAO itemDAO = new ItemDAO();
        String itemNameForPrice = request.getParameter("first");
        Item item = itemDAO.minItemPrice(itemNameForPrice);
        request.setAttribute("item", item);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
