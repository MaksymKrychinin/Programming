package command;

import entitiy.Ticket;
import entitiy.Seance;

import javax.servlet.http.HttpServletRequest;

public class AddTicketCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        GetSeanceCommand gvc = new GetSeanceCommand();
        Seance seance = gvc.getSeance(request.getParameter("id"));
        Ticket ticket = new Ticket(seance, Integer.parseInt(request.getParameter("cost")));
        seance.addPlace(ticket);
        seance.minus();
        request.setAttribute("seance", seance);
        return "go_to_seance.jsp";
    }
}
