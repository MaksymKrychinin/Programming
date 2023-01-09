package Servlets;

import db.VocabularyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditVocabulary", value = "/EditVocabulary")
public class EditVocabulary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("role").equals("admin")) {
            String vocabularyName = request.getParameter("vocabularyName");
            String word = request.getParameter("word");
            String wordInfo = request.getParameter("wordInfo");
            VocabularyDAO vocabularyDAO = new VocabularyDAO();
            vocabularyDAO.editVocabulary(vocabularyName,word,wordInfo);
            request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "Not admin, plz login");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
