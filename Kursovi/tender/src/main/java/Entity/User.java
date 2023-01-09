package Entity;

public class User {
    int idUser;
    String username;
    int tenderSum;


    public int getTenderSum() {
        return tenderSum;
    }

    public void setTenderSum(int tenderSum) {
        this.tenderSum = tenderSum;
    }
    public User(int idUser, String username, int tenderSum) {
        this.idUser = idUser;
        this.tenderSum = tenderSum;
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
