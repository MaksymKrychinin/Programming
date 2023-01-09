package Servlets;

import Model.DAO.VacancyDAO;
import Model.Entity.Vacancy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser = (int) request.getSession().getAttribute("idUser");
        if (idUser>0) {
            String keywords = request.getParameter("keywords");
            VacancyDAO vacancyDAO = new VacancyDAO();
            List<Vacancy> vacancyList = vacancyDAO.vacancySearch(keywords);
            request.setAttribute("vacancyList", vacancyList);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
