package Entity;

import java.util.Date;

public class Currency {
    String name;

    public String getName() {
        return name;
    }

    public double getSellRate() {
        return sellRate;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public Date getDate() {
        return date;
    }

    double sellRate;
    double buyRate;
    Date date;

    public Currency(String name, double sellRate, double buyRate, Date date) {
        this.name = name;
        this.sellRate = sellRate;
        this.buyRate = buyRate;
        this.date = date;
    }

    public Currency(String name, double sellRate, double buyRate) {
        this.name = name;
        this.sellRate = sellRate;
        this.buyRate = buyRate;
    }
}
