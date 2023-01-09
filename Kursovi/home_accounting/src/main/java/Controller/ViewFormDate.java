package Controller;

import Model.DAO.AccountingDAO;
import Model.Entity.Buy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ViewFormDate", value = "/ViewFormDate")
public class ViewFormDate extends HttpServlet {
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
            Date date1 = Date.valueOf(request.getParameter("date1"));
            Date date2 = Date.valueOf(request.getParameter("date2"));
            AccountingDAO accountingDAO = new AccountingDAO();
            List<Buy> accountingList = accountingDAO.buyListBetweenDate(idUser, date1, date2);
            request.setAttribute("accountingList", accountingList);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
