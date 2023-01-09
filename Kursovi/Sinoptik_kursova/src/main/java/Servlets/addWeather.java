package Servlets;

import Entity.Location;
import Entity.Weather;
import Entity.WeatherDate;
import db.WeatherDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addWeather", value = "/addWeather")
public class addWeather extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("role").equals("admin")) {
            Location location = new Location(request.getParameter("location"));
            WeatherDate weatherDate = new WeatherDate(request.getParameter("date"));
            Weather weather = new Weather(request.getParameter("weather"), location, weatherDate);
            WeatherDAO weatherDAO = new WeatherDAO();
            weatherDAO.addWeather(weather);
            request.getRequestDispatcher("adminPanel.jsp").forward(request,response);
        } else{
            request.getSession().setAttribute("status", "Not admin, plz login");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}
