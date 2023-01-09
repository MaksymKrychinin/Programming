package Model;

import Entity.Profile;

public interface UserDAO {
    boolean accountExist(String login, String password);

    Profile login(String login, String password);
    boolean register(String userName, String login, String password,
                     String infoAboutUser, String privateInfo);
    void changePassword(Profile profile, String passwordToChange);
    void changeInfoAboutUser(Profile profile, String infoAboutUser);
    void changePrivateInfo(Profile profile, String infoAboutUser);
    Profile userById(int id);
    boolean friends(int id, int id1);
    boolean acceptFriends(int id, int id1);
}
