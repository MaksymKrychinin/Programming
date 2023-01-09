package Model.Entity;

import java.sql.Time;

public class Schedule {
    int id;
    Time time;
    int idUser;

    public Schedule(int id, Time time, int idUser) {
        this.id = id;
        this.time = time;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
