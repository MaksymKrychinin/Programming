package Model;

import Entity.Auction;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuctionDao {

    public List<Auction> actualAuctions() {
        List<Auction> auctionList = new ArrayList<>();
        String query = "SELECT q.idauction, q.auctionName, u.username FROM auction.auctions q\n" +
                "INNER JOIN auction.users u ON q.idCreator=u.idusers;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String creator = resultSet.getString(3);
                Auction auction = new Auction(id, name, creator);
                auctionList.add(auction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auctionList;
    }

    public Auction getAuctionById(int id) {
        Auction auction = null;
        String query1 = "SELECT qs.idauction, qs.auctionName, IF(qs.status, 'true','false'), \n" +
                "username, qs.idCreator\n" +
                "FROM auction.auctions qs\n" +
                "INNER JOIN auction.users u ON qs.idCreator=u.idusers where qs.idauction=?\n" +
                "limit 1;";
        String query2 = "SELECT u.idusers, u.username, q.countJoin FROM auction.auctionusers q\n" +
                "inner join auction.users u ON q.idUser=u.idusers\n" +
                "where q.idauction=?;\n";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setInt(1, id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            int idauction = resultSet.getInt(1);
            String auctionName = resultSet.getString(2);
            boolean status = resultSet.getBoolean(3);
            String creatorName = resultSet.getString(4);
            int idCreator = resultSet.getInt(5);
            auction = new Auction(auctionName, idauction, creatorName, status, idCreator);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, id);
            resultSet = preparedStatement2.executeQuery();
            while(resultSet.next()) {
                int idUser = resultSet.getInt(1);
                String username = resultSet.getString(2);
                int count=resultSet.getInt(3);
                User user = new User(idUser, username, count);
                auction.addToList(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auction;
    }


    public void startStop(int auctionId, int status) {
        String query = "UPDATE auction.auctions SET status = ? where idauction = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, auctionId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAuction(String auctionName, int idCreator) {
        String query = "INSERT IGNORE INTO auction.auctions(auctionName, idCreator) VALUES(?, ?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, auctionName);
            preparedStatement.setInt(2, idCreator);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void joinAuction(int idAuction, int idCurrentUser, int countJoin) {
        String query = "INSERT IGNORE INTO auctionusers(idauction, idUser, countJoin)\n" +
                "VALUES(?,?,?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idAuction);
            preparedStatement.setInt(2, idCurrentUser);
            preparedStatement.setInt(3, countJoin);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Auction> createAuction(String auctionName) {
        List<Auction> auctionList = new ArrayList<>();
        String query = "SELECT q.idauction, q.auctionName, u.username FROM auction.auctions q\n" +
                "INNER JOIN auction.users u ON q.idCreator=u.idusers where q.auctionName like CONCAT('%',?,'%');";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, auctionName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String creator = resultSet.getString(3);
                Auction auction = new Auction(id, name, creator);
                auctionList.add(auction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auctionList;
    }

    public void deleteAuction(int auctionId) {
        String query = "DELETE FROM auction.auctions where idauction = ?";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, auctionId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
