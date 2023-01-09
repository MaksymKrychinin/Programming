package DB;

public interface DAO {
    boolean add(String PIB, String date, String password, String login);
    boolean currentUser(String login, String password);
    String name(String login);
    String date(String login);
    boolean editProfile(String login, String PIB, String date, String currentPassword, String newPassword);
}
