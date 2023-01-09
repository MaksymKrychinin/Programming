package Controller;

import Model.DAO.DoctorsDAO;
import Model.Entity.Schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JoinSchedule", value = "/JoinSchedule")
public class JoinSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        if (userId > 0) {
            int idSchedule = Integer.parseInt(request.getParameter("id"));
            DoctorsDAO doctorsDAO = new DoctorsDAO();
            doctorsDAO.joinInSchedule(userId,idSchedule);

            request.getRequestDispatcher("GetDoctorById?idDoctor="+
                    request.getSession().getAttribute("idDoctor")).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
