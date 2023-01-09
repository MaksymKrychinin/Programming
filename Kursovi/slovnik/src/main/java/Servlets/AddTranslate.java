package Servlets;

import db.TranslateDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddTranslate", value = "/AddTranslate")
public class AddTranslate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("role").equals("admin")) {
            String language = request.getParameter("language");
            String word = request.getParameter("word");
            String languageToTranslate = request.getParameter("languageToTranslate");
            String wordTranslate = request.getParameter("wordTranslate");
            TranslateDAO translateDAO = new TranslateDAO();
            translateDAO.addTranslate(language, word, languageToTranslate, wordTranslate);
            request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "Not admin, plz login");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
