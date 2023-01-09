package Model;

import Entity.Profile;
import Entity.ProfileList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class InviteDAOimpl implements InviteDAO {

    private ProfileList profileList;

    @Override
    public ProfileList accountInvitesList(int idF) {
        String query = "SELECT idProfile, username, openInfo FROM invitelist e\n" +
                "INNER JOIN profile p ON p.idProfile = e.idProfileTo\n" +
                "where p.idProfile=(select table1.idProfileTo from " +
                "(SELECT idProfileFrom, idProfileTo FROM invitelist union " +
                "SELECT idProfileTo, idProfileFrom FROM invitelist) table1\n" +
                "left join (SELECT * FROM invitelist) table2 On table1.idProfileTo=table2.idProfileTo " +
                "and table1.idProfileFrom=table2.idProfileFrom " +
                "where table2.idProfileTo is null and table1.idProfileFrom=?\n" +
                ")";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idF);
            ResultSet elements = preparedStatement.executeQuery();
            profileList=new ProfileList();
            while (elements.next()){
                int id = elements.getInt(1);
                String username = elements.getString(2);
                String openInfo = elements.getString(3);
                profileList.addProfileList(new Profile(id, username, openInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profileList;
    }

    @Override
    public ProfileList accountFriendsList(int idF) {
        String query = "SELECT idProfile, username, openInfo, privateInfo FROM invitelist e\n" +
                "INNER JOIN profile p ON p.idProfile = e.idProfileTo\n" +
                "where e.idProfileFrom=? and \n" +
                "e.idProfileTo in (SELECT idProfileFrom FROM invitelist where idProfileTo=?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idF);
            preparedStatement.setInt(2, idF);
            ResultSet elements = preparedStatement.executeQuery();
            profileList=new ProfileList();
            while (elements.next()){
                int id = elements.getInt(1);
                String username = elements.getString(2);
                String openInfo = elements.getString(3);
                String privateInfo = elements.getString(4);
                profileList.addProfileList(new Profile(id, username, openInfo, privateInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profileList;
    }

    @Override
    public ProfileList accountSearchList(String likeAn) {
        String query = "SELECT idProfile, username, openInfo FROM profile \n" +
                "where username LIKE ?;";
        if(likeAn.isEmpty()){return null;}
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, likeAn);
            ResultSet elements = preparedStatement.executeQuery();
            profileList=new ProfileList();
            while (elements.next()){
                int id = elements.getInt(1);
                String username = elements.getString(2);
                String openInfo = elements.getString(3);
                profileList.addProfileList(new Profile(id, username, openInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profileList;
    }

}
