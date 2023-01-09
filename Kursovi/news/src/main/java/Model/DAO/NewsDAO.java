package Model.DAO;

import Model.DB.DBConnection;
import Model.Entity.News;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {

    public List<News> allNews() {
        List<News> newsList = new ArrayList<>();
        String query = "SELECT news, newsCategory, date FROM news.news;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String news = resultSet.getString(1);
                String newsCatalog = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                News newsObj = new News(news,newsCatalog,date);
                newsList.add(newsObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
    public List<News> newsOnCategory(String category) {
        List<News> newsList = new ArrayList<>();
        String query = "SELECT news, newsCategory, date FROM news.news where newsCategory=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,category);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String news = resultSet.getString(1);
                String newsCatalog = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                News newsObj = new News(news,newsCatalog,date);
                newsList.add(newsObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
    public List<News> newsOnKeywords(String keywords) {
        List<News> newsList = new ArrayList<>();
        String query = "SELECT news, newsCategory, date FROM news.news where news like CONCAT( '%',?,'%');";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,keywords);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String news = resultSet.getString(1);
                String newsCatalog = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                News newsObj = new News(news,newsCatalog,date);
                newsList.add(newsObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public void createNews(String news, String category, Date date) {
        String query = "INSERT IGNORE INTO news.news(news, newsCategory, date) VALUES (?,?,?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,news);
            preparedStatement.setString(2,category);
            preparedStatement.setDate(3,date);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
