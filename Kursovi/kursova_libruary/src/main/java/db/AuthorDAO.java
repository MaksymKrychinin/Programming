package db;

import Entity.Author;
import Entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    public List<Author> searchBookByKeywords(String keyword) {
        String currentAuthor;
        Author author;
        List<Author> authorList = new ArrayList<>();
        String query = "SELECT authorName, bookName, keyWords FROM libruary.authorbook\n" +
                "Inner join libruary.book On authorbook.idBook=book.idBook\n" +
                "inner join libruary.author On authorbook.idAuthor=author.idAuthor\n" +
                "where find_in_set(?,keyWords)>0\n" +
                "order by authorName;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"#"+ keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                currentAuthor = resultSet.getString(1);
                author = new Author(currentAuthor);
                Book book = new Book(resultSet.getString(2), resultSet.getString(3));
                author.addBookList(book);
                authorList.add(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public List<Author> searchBookByName(String nameOfBook) {
        String currentAuthor;
        Author author;
        List<Author> authorList = new ArrayList<>();
        String query = "SELECT authorName, bookName, keyWords FROM libruary.authorbook\n" +
                "Inner join libruary.book On authorbook.idBook=book.idBook\n" +
                "inner join libruary.author On authorbook.idAuthor=author.idAuthor\n" +
                "where bookName Like CONCAT( '%',?,'%') \n" +
                "order by authorName;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nameOfBook);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                currentAuthor = resultSet.getString(1);
                author = new Author(currentAuthor);
                Book book = new Book(resultSet.getString(2), resultSet.getString(3));
                author.addBookList(book);
                authorList.add(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public List<Author> searchBookByAuthor(String authorName) {
        String currentAuthor;
        Author author;
        List<Author> authorList = new ArrayList<>();
        String query = "SELECT authorName, bookName, keyWords FROM libruary.authorbook\n" +
                "Inner join libruary.book On authorbook.idBook=book.idBook\n" +
                "inner join libruary.author On authorbook.idAuthor=author.idAuthor\n" +
                "where authorName like ? \n" +
                "order by authorName;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + authorName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                currentAuthor = resultSet.getString(1);
                author = new Author(currentAuthor);
                Book book = new Book(resultSet.getString(2), resultSet.getString(3));
                author.addBookList(book);
                authorList.add(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorList;
    }

}
