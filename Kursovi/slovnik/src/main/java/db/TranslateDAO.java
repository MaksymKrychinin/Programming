package db;

import Entity.Translate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TranslateDAO {
    Translate translate;

    public void addTranslate(String language, String word, String languageToTranslate, String wordTranslate) {
        String query = "INSERT IGNORE INTO slovnik.wordtranslate(Language, word, LanguageToTranslate, wordTranslate) " +
                "values (?,?,?,?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, language);
            preparedStatement1.setString(2, word);
            preparedStatement1.setString(3, languageToTranslate);
            preparedStatement1.setString(4, wordTranslate);
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTranslate(String word, String wordTranslate) {
        String query = "DELETE FROM slovnik.wordtranslate" +
                "where word=? and wordTranslate=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, word);
            preparedStatement1.setString(2, wordTranslate);
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTranslate(String word, String wordTranslate, String word1, String wordTranslate1) {
        String query = "UPDATE wordtranslate set word = ?, wordTranslate=? where word =? and wordTranslate=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, word);
            preparedStatement1.setString(2, wordTranslate);
            preparedStatement1.setString(3, word1);
            preparedStatement1.setString(4, wordTranslate1);
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Translate getTranslate(String language, String word, String languageToTranslate) {
        String query = "SELECT wordTranslate FROM slovnik.wordtranslate " +
                "where Language=? and word=? and LanguageToTranslate=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, language);
            preparedStatement1.setString(2, word);
            preparedStatement1.setString(3, languageToTranslate);
            ResultSet set = preparedStatement1.executeQuery();
            if (set.next()) {
                String wordTranslate = set.getString(1);
                translate = new Translate(language, word, languageToTranslate, wordTranslate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return translate;
    }
}
