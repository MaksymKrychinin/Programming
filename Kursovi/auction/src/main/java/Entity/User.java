package Entity;

public class User {
    int idUser;
    String username;
    int auctionSum;


    public int getAuctionSum() {
        return auctionSum;
    }

    public void setAuctionSum(int auctionSum) {
        this.auctionSum = auctionSum;
    }
    public User(int idUser, String username, int auctionSum) {
        this.idUser = idUser;
        this.auctionSum = auctionSum;
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
