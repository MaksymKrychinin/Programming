package Entity;

public class Profile {
    int id;
    String username;
    String login;
    String password;
    String openInfo;
    String privateInfo;

    public Profile(int id, String username, String login, String password, String openInfo, String privateInfo) {
        this.id = id;
        this.username = username;
        this.login = login;
        this.password = password;
        this.openInfo = openInfo;
        this.privateInfo = privateInfo;
    }
    public Profile(int id, String username, String openInfo) {
        this.id = id;
        this.username = username;
        this.openInfo = openInfo;
    }

    public Profile() {
    }

    public Profile(int id, String username, String openInfo, String privateInfo) {
        this.id = id;
        this.username = username;
        this.openInfo = openInfo;
        this.privateInfo = privateInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getOpenInfo() {
        return openInfo;
    }

    public void setOpenInfo(String openInfo) {
        this.openInfo = openInfo;
    }

    public String getPrivateInfo() {
        return privateInfo;
    }

    public void setPrivateInfo(String privateInfo) {
        this.privateInfo = privateInfo;
    }

}
