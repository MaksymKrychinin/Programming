package Servlets;

import Model.DAO.VacancyDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userPermission = (int) request.getSession().getAttribute("userPermission");
        if (userPermission == 1) {
            int idUser = (int) request.getSession().getAttribute("idUser");
            int idVacancy = Integer.parseInt(request.getParameter("idVacancy"));
            VacancyDAO vacancyDAO = new VacancyDAO();
            vacancyDAO.deleteVacancy(idUser, idVacancy);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
