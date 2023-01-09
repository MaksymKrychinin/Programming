package command;

import entitiy.Cinema;
import entitiy.Seance;
import entitiy.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MainCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        Cinema cinema = Cinema.getCinema();
        ArrayList<Seance> seances = cinema.getSeances();
        request.setAttribute("seances", seances);

        return "main.jsp";
    }
}
