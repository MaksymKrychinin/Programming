package Entity;

public class User {
    private int idUser;
    private String login;
    private String password;
    private String lastname;
    private String name;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int idUser, String login, String password, String lastname, String name) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.name = name;
    }

    public User(String login, String password, String lastname, String name) {
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.name = name;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
