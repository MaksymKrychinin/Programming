package entitiy;

public class Ticket {

    private String userName;
    private final int number;
    private final Seance seance;
    private int cost;
    private boolean buy;

    public Ticket(Seance seance, int cost) {
        number = seance.getTickets().size()+1;
        this.seance = seance;
        this.cost = cost;
        buy = false;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumber() {
        return number;
    }

    public Seance getSeance() {
        return seance;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

