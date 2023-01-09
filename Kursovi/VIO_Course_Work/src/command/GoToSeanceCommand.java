package command;

import entitiy.Seance;

import javax.servlet.http.HttpServletRequest;

public class GoToSeanceCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        GetSeanceCommand gvc = new GetSeanceCommand();
        Seance seance = gvc.getSeance(request.getParameter("id"));
        request.setAttribute("seance", seance);
        request.setAttribute("pTickets", seance.getPurchasedTickets());
        return "go_to_seance.jsp";
    }
}
