package command;

import entitiy.Seance;
import entitiy.Ticket;

import javax.servlet.http.HttpServletRequest;

public class DeleteTicketCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        GetSeanceCommand gvc = new GetSeanceCommand();
        Seance seance = gvc.getSeance(request.getParameter("id"));
        GetTicketCommand gtc = new GetTicketCommand();
        Ticket ticket = gtc.getTicket(seance, request.getParameter("idTicket"));
        seance.removeTicket(ticket);
        seance.plus();
        request.setAttribute("seance", seance);
        return "go_to_seance.jsp";
    }
}
