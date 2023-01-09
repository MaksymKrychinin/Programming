package command;

import entitiy.Seance;
import entitiy.Ticket;

import javax.servlet.http.HttpServletRequest;

public class BuyTicketCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        GetSeanceCommand gvc = new GetSeanceCommand();
        Seance seance = gvc.getSeance(request.getParameter("id"));
        GetTicketCommand gtc = new GetTicketCommand();
        Ticket ticket = gtc.getTicket(seance, request.getParameter("idTicket"));
        ticket.setUserName(request.getParameter("name"));
        ticket.setBuy(true);
        seance.addPurchasedTicket(ticket);
        request.setAttribute("seance", seance);
        request.setAttribute("pTickets", seance.getPurchasedTickets());
        return "go_to_seance.jsp";
    }
}
