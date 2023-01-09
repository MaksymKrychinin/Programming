package Model.Entity;

import java.sql.Date;

public class Buy {
    int idBuy;
    String buyName;
    String category;
    Date date;
    double cost;

    public Buy(int idBuy, String buyName, String category, Date date, double cost) {
        this.idBuy = idBuy;
        this.buyName = buyName;
        this.category = category;
        this.date = date;
        this.cost = cost;
    }

    public int getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(int idBuy) {
        this.idBuy = idBuy;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
