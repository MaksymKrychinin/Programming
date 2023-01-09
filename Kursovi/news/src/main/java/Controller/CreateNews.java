package Controller;

import Model.DAO.NewsDAO;
import Model.Entity.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CreateNews", value = "/CreateNews")
public class CreateNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        int admin = (int) request.getSession().getAttribute("admin");
        if (userId > 0 && admin == 1) {
            String news = request.getParameter("news");
            String category = request.getParameter("category");
            Date date = Date.valueOf(request.getParameter("date"));
            NewsDAO newsDAO = new NewsDAO();
            newsDAO.createNews(news, category, date);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
