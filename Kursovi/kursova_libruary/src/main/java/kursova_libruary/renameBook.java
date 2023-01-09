package kursova_libruary;

import db.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "renameBook", value = "/renameBook")
public class renameBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((boolean) request.getSession().getAttribute("admin") == true) {
            String bookName = request.getParameter("bookName");
            String newBookName = request.getParameter("newBookName");
            BookDAO bookDAO = new BookDAO();
            bookDAO.renameBook(bookName, newBookName);
            request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
        }
    }
}