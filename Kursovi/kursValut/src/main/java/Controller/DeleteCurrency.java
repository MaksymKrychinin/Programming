package Controller;

import Model.DB.CurrencyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCurrency", value = "/DeleteCurrency")
public class DeleteCurrency extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean admin = (boolean) request.getSession().getAttribute("admin");
        if (admin) {
            String name = request.getParameter("name");
            CurrencyDAO.deleteCurrency(name);
            request.setAttribute("status", "Done");
        }
        request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
    }
}
