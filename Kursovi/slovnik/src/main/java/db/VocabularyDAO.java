package db;

import Entity.Translate;
import Entity.Vocabulary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VocabularyDAO {
    public void addVocabulary(String vocabularyName, String word, String wordInfo) {
        String query = "INSERT IGNORE INTO slovnik.vocabulary(VocabularyName, word, WordInfo) " +
                "values (?,?,?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, vocabularyName);
            preparedStatement1.setString(2, word);
            preparedStatement1.setString(3, wordInfo);
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVocabulary(String vocabularyName, String word) {
        String query = "DELETE FROM slovnik.vocabulary" +
                "where VocabularyName=? and word=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, vocabularyName);
            preparedStatement1.setString(2, word);
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editVocabulary(String vocabularyName, String word, String wordInfo) {
        String query = "UPDATE vocabulary set WordInfo = ? where VocabularyName =? and word=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, wordInfo);
            preparedStatement1.setString(2, vocabularyName);
            preparedStatement1.setString(3, word);
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Vocabulary> getVocabulary(String vocabularyName) {
        String query = "SELECT word, WordInfo FROM slovnik.vocabulary where VocabularyName=?;";
        List<Vocabulary> vocabularyList = new ArrayList<>();
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, vocabularyName);
            ResultSet set = preparedStatement1.executeQuery();
            while (set.next()){
                String word = set.getString(1);
                String wordInfo = set.getString(2);
                vocabularyList.add(new Vocabulary(vocabularyName, word, wordInfo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vocabularyList;
    }
}
