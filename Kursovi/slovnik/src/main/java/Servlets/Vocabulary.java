package Servlets;

import Entity.Translate;
import db.TranslateDAO;
import db.VocabularyDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Vocabulary", value = "/Vocabulary")
public class Vocabulary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null) {
            String vocabularyName = request.getParameter("vocabularyName");
            VocabularyDAO vocabularyDAO = new VocabularyDAO();
            List<Entity.Vocabulary> vocabularyList = vocabularyDAO.getVocabulary(vocabularyName);
            request.getSession().setAttribute("vocabularyList", vocabularyList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "BAD LOGIN");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
