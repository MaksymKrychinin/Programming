package kursova_libruary;

import Entity.Author;
import db.AuthorDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchByAuthor", value = "/SearchByAuthor")
public class SearchByAuthor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchText = request.getParameter("searchParameter");
        AuthorDAO authorDAO = new AuthorDAO();
        List<Author> returnList = authorDAO.searchBookByAuthor(searchText);
        request.setAttribute("list", returnList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
