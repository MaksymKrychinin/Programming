package Entity;


import java.sql.Date;

public class WeatherDate {
    Date date;

    public java.sql.Date getDate() {
        return date;
    }

    public WeatherDate(String date) {
        this.date = java.sql.Date.valueOf(date);
    }
    public WeatherDate(Date date) {
        this.date = date;
    }

}
