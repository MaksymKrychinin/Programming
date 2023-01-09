package command;

import entitiy.Cinema;
import entitiy.Seance;

import javax.servlet.http.HttpServletRequest;

public class DeleteSeanceCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        GetSeanceCommand gvc = new GetSeanceCommand();
        Seance seance = gvc.getSeance(request.getParameter("id"));
        Cinema.getCinema().removeSeance(seance);
        return "controller?action=main";
    }
}
