package kursova_libruary;

import db.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addBook", value = "/addBook")
public class addBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((boolean) request.getSession().getAttribute("admin") == true) {
            String bookName = request.getParameter("bookName");
            String authorName = request.getParameter("authorName");
            String keywords = request.getParameter("keywords");
            BookDAO bookDAO = new BookDAO();
            bookDAO.addBook(authorName, bookName, keywords);
            request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
        }
    }
}