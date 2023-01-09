package Controller;

import Model.DAO.NewsDAO;
import Model.Entity.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchCategory", value = "/SearchCategory")
public class SearchCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        if (userId > 0) {
            String category = request.getParameter("category");
            NewsDAO newsDAO = new NewsDAO();
            List<News> newsList = newsDAO.newsOnCategory(category);
            request.getSession().setAttribute("newsList", newsList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
