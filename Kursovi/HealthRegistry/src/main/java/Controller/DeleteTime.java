package Controller;

import Model.DAO.DoctorsDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;

@WebServlet(name = "DeleteTime", value = "/DeleteTime")
public class DeleteTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        int admin = (int) request.getSession().getAttribute("admin");
        if (userId > 0 && admin == 1) {
            String doctorName = request.getParameter("doctorName");
            Time time = Time.valueOf(request.getParameter("time"));
            DoctorsDAO doctorsDAO = new DoctorsDAO();
            doctorsDAO.deleteTime(doctorName,time);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
