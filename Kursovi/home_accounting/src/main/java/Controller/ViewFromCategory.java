package Controller;

import Model.DAO.AccountingDAO;
import Model.Entity.Buy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ViewFromCategory", value = "/ViewFromCategory")
public class ViewFromCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int idUser = (int) request.getSession().getAttribute("idUser");
        if (idUser == 0) {
            request.setAttribute("error", "Помилка, ввідіть в аккаунт");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            String category = request.getParameter("category");
            AccountingDAO accountingDAO = new AccountingDAO();
            List<Buy> accountingList = accountingDAO.buyListOnCategory(idUser, category);
            request.setAttribute("accountingList", accountingList);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
