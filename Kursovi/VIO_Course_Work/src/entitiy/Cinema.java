package entitiy;

import java.util.*;

public class Cinema {

    private static Cinema cinema = new Cinema();
    private Map<String, User> users = new HashMap<>();
    private ArrayList<Seance> seances = new ArrayList<>();
    private int id = 0;

    public int getId() {
        id++;
        return id;
    }

    public static Cinema getCinema() {
        if (cinema ==null) {
            cinema = new Cinema();
        }
        return cinema;
    }

    public void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    public void addSeance(Seance seance) {
        seances.add(seance);
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public void setSeances(ArrayList<Seance> seances) {
        this.seances = seances;
    }

    public static void setCinema(Cinema cinema) {
        Cinema.cinema = cinema;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

}
