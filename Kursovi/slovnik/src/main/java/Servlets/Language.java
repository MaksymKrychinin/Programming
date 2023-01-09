package Servlets;

import Entity.Translate;
import db.TranslateDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Language", value = "/Language")
public class Language extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null) {
            String language = request.getParameter("language");
            String languageToTranslate = request.getParameter("languageToTranslate");
            String word = request.getParameter("word");
            TranslateDAO translateDAO = new TranslateDAO();
            Translate translate = translateDAO.getTranslate(language,word,languageToTranslate);
            request.getSession().setAttribute("translate", translate);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "BAD LOGIN");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
