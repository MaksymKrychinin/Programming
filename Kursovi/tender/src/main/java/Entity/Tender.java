package Entity;

import java.util.ArrayList;
import java.util.List;

public class Tender {
    String tenderName;
    int idTender;
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


    public Tender() {
        list = new ArrayList<User>();
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public int getIdTender() {
        return idTender;
    }

    public void setIdTender(int idTender) {
        this.idTender = idTender;
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

    public Tender(String tenderName, int idTender, String creator, boolean status, int idCreator) {
        this.tenderName = tenderName;
        this.idTender = idTender;
        this.creator = creator;
        this.list = new ArrayList<>();
        this.status = status;
        this.idCreator = idCreator;
    }

    public Tender(int idTender, String tenderName, String creator) {
        this.idTender = idTender;
        this.tenderName = tenderName;
        this.creator = creator;
    }

}
