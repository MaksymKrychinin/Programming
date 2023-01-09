package Servlets;

import Entity.Location;
import Entity.WeatherDate;
import db.WeatherDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "weatherOneDay", value = "/weatherOneDay")
public class weatherOneDay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null) {
            Location location = new Location(request.getParameter("location"));
            WeatherDate date = new WeatherDate(request.getParameter("date"));
            WeatherDAO weatherDAO = new WeatherDAO();
            request.getSession().setAttribute("weatherOneDay", weatherDAO.weatherOneDay(location, date));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "BAD LOGIN");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
