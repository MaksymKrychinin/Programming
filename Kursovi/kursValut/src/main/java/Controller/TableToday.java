package Controller;

import Model.DB.ExchangeDAO;
import Entity.ExchangeRate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TableToday", value = "/TableToday")
public class TableToday extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExchangeRate exchange = ExchangeDAO.tableToday();
        request.setAttribute("table", exchange);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
