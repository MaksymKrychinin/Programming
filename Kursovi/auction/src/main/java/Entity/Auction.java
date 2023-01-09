package Entity;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    String auctionName;
    int idAuction;
    String creator;

    public int getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(int idCreator) {
        this.idCreator = idCreator;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    int idCreator;
    List<User> list;
    boolean status;


    public Auction() {
        list = new ArrayList<User>();
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public int getIdAuction() {
        return idAuction;
    }

    public void setIdAuction(int idAuction) {
        this.idAuction = idAuction;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<User> getList() {
        return list;
    }

    public void addToList(User user) {
        this.list.add(user);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Auction(String auctionName, int idAuction, String creator, boolean status, int idCreator) {
        this.auctionName = auctionName;
        this.idAuction = idAuction;
        this.creator = creator;
        this.list = new ArrayList<>();
        this.status = status;
        this.idCreator = idCreator;
    }

    public Auction(int idAuction, String auctionName, String creator) {
        this.idAuction = idAuction;
        this.auctionName = auctionName;
        this.creator = creator;
    }

}
