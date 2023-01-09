package Servlets;

import db.TranslateDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditTranslate", value = "/EditTranslate")
public class EditTranslate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("role").equals("admin")) {
            String word = request.getParameter("word");
            String wordTranslate = request.getParameter("wordTranslate");
            String word1 = request.getParameter("word1");
            String wordTranslate1 = request.getParameter("wordTranslate1");
            TranslateDAO translateDAO = new TranslateDAO();
            translateDAO.editTranslate(word,wordTranslate,word1,wordTranslate1);
            request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "Not admin, plz login");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
