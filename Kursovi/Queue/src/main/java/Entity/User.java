package Entity;

public class User {
    int idUser;
    String username;

    public int getNumberInQueue() {
        return numberInQueue;
    }

    public void setNumberInQueue(int numberInQueue) {
        this.numberInQueue = numberInQueue;
    }

    int numberInQueue;
    public User(int idUser, String username, int numberInQueue) {
        this.idUser = idUser;
        this.numberInQueue=numberInQueue;
        this.username = username;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
