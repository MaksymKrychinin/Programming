package Controller;

import Model.DB.ExchangeDAO;
import Entity.ExchangeRate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "TableOnDate", value = "/TableOnDate")
public class TableOnDate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Date date1 = Date.valueOf(request.getParameter("date1"));
        Date date2 = Date.valueOf(request.getParameter("date2"));
        ExchangeRate exchange = ExchangeDAO.tableOnDateFromDateTo(name, date1, date2);
        request.setAttribute("teble", exchange);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
