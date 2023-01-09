package Controller;

import Model.DAO.DoctorsDAO;
import Model.Entity.Doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllDoctors", value = "/AllDoctors")
public class AllDoctors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        if (userId > 0) {
            DoctorsDAO doctorsDAO = new DoctorsDAO();
            List<Doctor> doctorList = doctorsDAO.allDoctors();
            request.getSession().setAttribute("doctorsList", doctorList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
