package command;

import entitiy.*;
import entitiy.Cinema;

import javax.servlet.http.HttpServletRequest;

public class CreateSeanceCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Seance seance = new Seance(user, request.getParameter("header"), Integer.parseInt(request.getParameter("num")));
        Cinema.getCinema().addSeance(seance);
        return "controller?action=main";
    }
}
