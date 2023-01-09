package Servlets;

import Entity.Location;
import Entity.WeatherDate;
import db.WeatherDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "weatherList", value = "/weatherList")
public class weatherList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");
        if (role != null) {
            Location location = new Location(request.getParameter("location"));
            WeatherDate date1 = new WeatherDate(request.getParameter("date1"));
            WeatherDate date2 = new WeatherDate(request.getParameter("date2"));
            WeatherDAO weatherDAO = new WeatherDAO();
            request.getSession().setAttribute("weatherList", weatherDAO.weatherList(location, date1, date2));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("status", "BAD LOGIN");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
