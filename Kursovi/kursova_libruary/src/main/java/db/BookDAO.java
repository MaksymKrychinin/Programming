package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {
    public void addBook(String authorName, String bookName, String keyWords) {
        String query1="INSERT IGNORE INTO libruary.book (bookName, keyWords) VALUES(?,?);";
        String query2="INSERT IGNORE INTO libruary.author (authorName) VALUES(?);";
        String query3 = "INSERT INTO libruary.authorbook(idAuthor, idBook) VALUES\n" +
                " ((SELECT idAuthor From libruary.author where authorName=?)," +
                "(SELECT idBook From libruary.book where bookName=?));";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
           preparedStatement1.setString(1, bookName);
            preparedStatement1.setString(2, keyWords);
            preparedStatement2.setString(1, authorName);
            preparedStatement3.setString(1, authorName);
            preparedStatement3.setString(2, bookName);
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String bookName) {
        String query = "DELETE FROM authorbook where idBook=" +
                "(select idbook from book where bookName=?);\n" +
                "DELETE From book where bookName=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookName);
            preparedStatement.setString(1, bookName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renameBook(String bookName, String newBookName) {
        String query = "UPDATE book \n" +
                "SET bootName=?\n" +
                "WHERE bookName =?";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newBookName);
            preparedStatement.setString(1, bookName);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
