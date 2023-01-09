package Servlets;

import Model.DAO.VacancyDAO;
import Model.Entity.Vacancy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllVacancies", value = "/AllVacancies")
public class AllVacancies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userPermission = (int) request.getSession().getAttribute("userPermission");
        if (userPermission == 1) {
            VacancyDAO vacancyDAO = new VacancyDAO();
            int idUser = (int) request.getSession().getAttribute("idUser");
            List<Vacancy> vacancyList = vacancyDAO.allVacancyForEmployer(idUser);
            request.setAttribute("vacancyList", vacancyList);
        } else if (userPermission == 0) {
            VacancyDAO vacancyDAO = new VacancyDAO();
            List<Vacancy> vacancyList = vacancyDAO.allVacancyForWorker();
            request.setAttribute("vacancyList", vacancyList);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
