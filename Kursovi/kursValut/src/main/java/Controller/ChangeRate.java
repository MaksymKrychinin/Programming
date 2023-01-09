package Controller;

import Model.DB.ExchangeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ChangeRate", value = "/ChangeRate")
public class ChangeRate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean admin = (boolean) request.getSession().getAttribute("admin");
        if (admin) {
            String name = request.getParameter("name");
            String date = request.getParameter("date");
            double sellRate = Double.parseDouble(request.getParameter("sellRate"));
            double buyRate = Double.parseDouble(request.getParameter("buyRate"));
            ExchangeDAO.addExchangeRate(name, Date.valueOf(date), sellRate, buyRate);
            request.setAttribute("status", "Done");
        }
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
