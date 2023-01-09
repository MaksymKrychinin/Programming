package Controller;

import Model.DAO.DoctorsDAO;
import Model.Entity.Doctor;
import Model.Entity.Schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetDoctorById", value = "/GetDoctorById")
public class GetDoctorById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        if (userId > 0) {
            int idDoctor = Integer.parseInt(request.getParameter("idDoctor"));
            request.getSession().setAttribute("idDoctor", idDoctor);
            DoctorsDAO doctorsDAO = new DoctorsDAO();
            List<Schedule> scheduleList = doctorsDAO.scheduleById(idDoctor);
            request.getSession().setAttribute("scheduleList", scheduleList);
            request.getRequestDispatcher("schedule.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
