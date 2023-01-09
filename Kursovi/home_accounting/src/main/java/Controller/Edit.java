package Controller;

import Model.DAO.AccountingDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "Edit", value = "/Edit")
public class Edit extends HttpServlet {
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
            int idBuy = Integer.parseInt(request.getParameter("idBuy"));
            String buyName = request.getParameter("buyName");
            String buyCategory = request.getParameter("buyCategory");
            Date buyDate = Date.valueOf(request.getParameter("buyDate"));
            double buyCost = Double.valueOf(request.getParameter("buyCost"));
            AccountingDAO accountingDAO = new AccountingDAO();
            accountingDAO.editBuy(idBuy, idUser, buyName, buyCategory, buyDate, buyCost);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
