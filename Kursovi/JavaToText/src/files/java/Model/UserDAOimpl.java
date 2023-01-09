package Model;

import Entity.Profile;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOimpl implements UserDAO {
    private boolean accountExist;
    private Profile profile;
    private boolean register;
    private boolean friends;
    private boolean acceptFriends;

    @Override
    public boolean accountExist(String login, String password) {
        String query = "SELECT COUNT(*) FROM profile WHERE login=? and password=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1) > 0) {
                accountExist = true;
            } else {
                accountExist = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountExist;
    }

    @Override
    public Profile login(String login, String password) {
        String query = "SELECT idProfile, username, openInfo, privateInfo FROM profile WHERE login=? and password=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, md5(password));
            ResultSet elements = preparedStatement.executeQuery();
            while (elements.next()) {
                int id = elements.getInt(1);
                String username = elements.getString(2);
                String openInfo = elements.getString(3);
                String privateInfo = elements.getString(4);
                profile = new Profile(id, username, login, password, openInfo, privateInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }

    @Override
    public boolean register(String username, String login, String password,
                            String infoAboutUser, String privateInfo) {
        register = false;
        String query = "insert profile(username, login, password, openInfo, privateInfo)\n" +
                "        VALUES (?, ?, ?, ?, ?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, md5(password));
            preparedStatement.setString(4, infoAboutUser);
            preparedStatement.setString(5, privateInfo);
            preparedStatement.executeUpdate();
            register = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return register;
    }

    @Override
    public void changePassword(Profile profile, String passwordToChange) {
        String query = "UPDATE profile set password=? where login = ? and idProfile = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, passwordToChange);
            preparedStatement.setString(2, profile.getLogin());
            preparedStatement.setInt(3, profile.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeInfoAboutUser(Profile profile, String infoAboutUser) {
        String query = "UPDATE profile set openInfo=? where login = ? and idProfile = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, infoAboutUser);
            preparedStatement.setString(2, profile.getLogin());
            preparedStatement.setInt(3, profile.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void changePrivateInfo(Profile profile, String infoAboutUser) {
        String query = "UPDATE profile set privateInfo=? where login = ? and idProfile = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, infoAboutUser);
            preparedStatement.setString(2, profile.getLogin());
            preparedStatement.setInt(3, profile.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Profile userById(int id) {
        String query = "SELECT username, openInfo, privateInfo FROM profile WHERE idProfile=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet elements = preparedStatement.executeQuery();
            while (elements.next()) {
                String username = elements.getString(1);
                String openInfo = elements.getString(2);
                String privateInfo = elements.getString(3);
                profile = new Profile(id, username, openInfo, privateInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }

    @Override
    public boolean friends(int id, int id1) {
        String query = "SELECT COUNT(*) FROM invitelist Where idProfileFrom=? and idProfileTo=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id1);
            ResultSet elements = preparedStatement.executeQuery();
            elements.next();
            if (elements.getInt(1) > 0) {
                friends = true;
            } else {
                friends = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return friends;
    }

    @Override
    public boolean acceptFriends(int id, int id1) {
        acceptFriends = false;
        String query = "insert invitelist(idProfileFrom, idProfileTo) values (?, ?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id1);
            preparedStatement.executeUpdate();
            acceptFriends = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acceptFriends;
    }

    String md5(String password) {
        return DigestUtils.md5Hex(password).toLowerCase();
    }
}
