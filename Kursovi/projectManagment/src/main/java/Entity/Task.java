package Entity;

import java.util.List;

public class Task {
    private int id;
    private String name;
    private int idUser;
    private String description;

    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task(String name, int idUser, String description) {
        this.name = name;
        this.idUser = idUser;
        this.description = description;
    }

    public Task(int id, String name, int idUser, String description) {
        this.id = id;
        this.name = name;
        this.idUser = idUser;
        this.description = description;
    }
}