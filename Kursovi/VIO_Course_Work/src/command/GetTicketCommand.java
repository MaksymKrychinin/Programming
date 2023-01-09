package command;

import entitiy.Cinema;
import entitiy.Seance;
import entitiy.Ticket;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetTicketCommand {

    public Ticket getTicket(Seance seance, String id) {
        Ticket ticket;
        ArrayList<Ticket> tickets = seance.getTickets();
        ArrayList<Integer> ids = tickets.stream()
                .map(Ticket::getNumber)
                .collect(Collectors.toCollection(ArrayList::new));
        int index = ids.indexOf(Integer.parseInt(id));
        ticket = tickets.get(index);
        return ticket;
    }

}
