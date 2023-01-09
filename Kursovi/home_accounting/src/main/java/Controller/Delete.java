package Controller;

import Model.DAO.AccountingDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = (int) request.getSession().getAttribute("idUser");
        if (idUser == 0) {
            request.setAttribute("error", "Помилка, ввідіть в аккаунт");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            int idBuy = Integer.parseInt(request.getParameter("idBuy"));
            AccountingDAO accountingDAO = new AccountingDAO();
            accountingDAO.deleteBuy(idBuy, idUser);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
