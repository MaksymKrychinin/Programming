package Controller;

import Model.DAO.DoctorsDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LeaveFromSchedule", value = "/LeaveFromSchedule")
public class LeaveFromSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        if (userId > 0) {
            int idSchedule = Integer.parseInt(request.getParameter("id"));
            DoctorsDAO doctorsDAO = new DoctorsDAO();
            doctorsDAO.leaveFromSchedule(userId,idSchedule);
            request.getRequestDispatcher("GetDoctorById?idDoctor="+
                    request.getSession().getAttribute("idDoctor")).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
