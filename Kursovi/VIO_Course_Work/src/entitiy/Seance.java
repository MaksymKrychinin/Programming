package entitiy;

import java.util.ArrayList;

public class Seance {

    private User creator;
    private String header;
    private int numberOfPlaces;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Ticket> purchasedTickets = new ArrayList<>();
    private final int id = Cinema.getCinema().getId();

    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(ArrayList<Ticket> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public Seance(User creator, String header, int numberOfPlaces) {
        this.creator = creator;
        this.header = header;
        this.numberOfPlaces = numberOfPlaces;
    }

    public void minus() {
        numberOfPlaces-=1;
    }

    public void plus() {
        numberOfPlaces+=1;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void addPurchasedTicket(Ticket ticket) {
        purchasedTickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getId() {
        return id;
    }

    public void addPlace(Ticket ticket){
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
