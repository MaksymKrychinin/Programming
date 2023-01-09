package Model;

import Entity.Tender;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TenderDAO {

    public List<Tender> actualTenders() {
        List<Tender> tenderList = new ArrayList<>();
        String query = "SELECT q.idtender, q.tenderName, u.username FROM tender.tenders q\n" +
                "INNER JOIN tender.users u ON q.idCreator=u.idusers;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String creator = resultSet.getString(3);
                Tender tender = new Tender(id, name, creator);
                tenderList.add(tender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenderList;
    }

    public Tender getTenderById(int id) {
        Tender tender = null;
        String query1 = "SELECT qs.idtender, qs.tenderName, IF(qs.status, 'true','false'), \n" +
                "username, qs.idCreator\n" +
                "FROM tender.tenders qs\n" +
                "INNER JOIN tender.users u ON qs.idCreator=u.idusers where qs.idtender=?\n" +
                "limit 1;";
        String query2 = "SELECT u.idusers, u.username, q.countJoin FROM tender.tenderusers q\n" +
                "inner join tender.users u ON q.idUser=u.idusers\n" +
                "where q.idtender=?;\n";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setInt(1, id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            int idtender = resultSet.getInt(1);
            String tenderName = resultSet.getString(2);
            boolean status = resultSet.getBoolean(3);
            String creatorName = resultSet.getString(4);
            int idCreator = resultSet.getInt(5);
            tender = new Tender(tenderName, idtender, creatorName, status, idCreator);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, id);
            resultSet = preparedStatement2.executeQuery();
            while(resultSet.next()) {
                int idUser = resultSet.getInt(1);
                String username = resultSet.getString(2);
                int count=resultSet.getInt(3);
                User user = new User(idUser, username, count);
                tender.addToList(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tender;
    }


    public void startStop(int tenderId, int status) {
        String query = "UPDATE tender.tenders SET status = ? where idtender = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, tenderId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTender(String tenderName, int idCreator) {
        String query = "INSERT IGNORE INTO tender.tenders(tenderName, idCreator) VALUES(?, ?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tenderName);
            preparedStatement.setInt(2, idCreator);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void joinTender(int idTender, int idCurrentUser, int countJoin) {
        String query = "INSERT IGNORE INTO tenderusers(idtender, idUser, countJoin)\n" +
                "VALUES(?,?,?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idTender);
            preparedStatement.setInt(2, idCurrentUser);
            preparedStatement.setInt(3, countJoin);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Tender> createTender(String tenderName) {
        List<Tender> tenderList = new ArrayList<>();
        String query = "SELECT q.idtender, q.tenderName, u.username FROM tender.tenders q\n" +
                "INNER JOIN tender.users u ON q.idCreator=u.idusers where q.tenderName like CONCAT('%',?,'%');";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tenderName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String creator = resultSet.getString(3);
                Tender tender = new Tender(id, name, creator);
                tenderList.add(tender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenderList;
    }

    public void deleteTender(int tenderId) {
        String query = "DELETE FROM tender.tenders where idtender = ?";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tenderId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
