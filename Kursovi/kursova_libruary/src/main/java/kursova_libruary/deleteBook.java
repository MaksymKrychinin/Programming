package kursova_libruary;

import db.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteBook", value = "/deleteBook")
public class deleteBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((boolean) request.getSession().getAttribute("admin") == true) {
            String bookName = request.getParameter("bookName");
            BookDAO bookDAO = new BookDAO();
            bookDAO.deleteBook(bookName);
            request.getRequestDispatcher("/adminPanel.jsp").forward(request, response);
        }
    }
}
