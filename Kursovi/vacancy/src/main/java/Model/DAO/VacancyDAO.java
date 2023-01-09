package Model.DAO;

import Model.DB.DBConnection;
import Model.Entity.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyDAO {
    public List<Vacancy> allVacancyForWorker() {
        List<Vacancy> vacancyList = new ArrayList<>();
        String query = "SELECT idvacancy, vacancyName, description, requirements FROM vacancy.vacancy;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idVacancy = resultSet.getInt(1);
                String vacancyName = resultSet.getString(2);
                String vacancyDescription = resultSet.getString(3);
                String vacancyRequirements = resultSet.getString(4);
                Vacancy vacancy = new Vacancy(idVacancy, vacancyName, vacancyDescription, vacancyRequirements);
                vacancyList.add(vacancy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    public List<Vacancy> allVacancyForEmployer(int idUser) {
        List<Vacancy> vacancyList = new ArrayList<>();
        String query = "SELECT idvacancy, vacancyName, description, requirements FROM vacancy.vacancy" +
                " where idCreator = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idVacancy = resultSet.getInt(1);
                String vacancyName = resultSet.getString(2);
                String vacancyDescription = resultSet.getString(3);
                String vacancyRequirements = resultSet.getString(4);
                Vacancy vacancy = new Vacancy(idVacancy, vacancyName, vacancyDescription, vacancyRequirements);
                vacancyList.add(vacancy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vacancyList;
    }
    public List<Vacancy> vacancySearch(String keyword) {
        List<Vacancy> vacancyList = new ArrayList<>();
        String query = "SELECT idvacancy, vacancyName, description, requirements FROM vacancy.vacancy v \n" +
                "where v.description like CONCAT( '%',?,'%') or \n" +
                "v.requirements like CONCAT( '%',?,'%') or \n" +
                "v.vacancyName like CONCAT( '%',?,'%');";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, keyword);
            preparedStatement.setString(2, keyword);
            preparedStatement.setString(3, keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idVacancy = resultSet.getInt(1);
                String vacancyName = resultSet.getString(2);
                String vacancyDescription = resultSet.getString(3);
                String vacancyRequirements = resultSet.getString(4);
                Vacancy vacancy = new Vacancy(idVacancy, vacancyName, vacancyDescription, vacancyRequirements);
                vacancyList.add(vacancy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vacancyList;
    }

    public void createVacancy(int idUser, String vacancyName, String vacancyDescription, String vacancyRequirements) {
        String query = "insert into vacancy.vacancy(idCreator, vacancyName, description, requirements)\n" +
                "VALUES (?,?,?,?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setString(2, vacancyName);
            preparedStatement.setString(3, vacancyDescription);
            preparedStatement.setString(4, vacancyRequirements);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editVacancy(int idUser, int idVacancy,
                            String vacancyName, String vacancyDescription, String vacancyRequirements) {
        String query = "UPDATE vacancy.vacancy SET vacancyName=?, description=?, requirements=?\n" +
                "where idvacancy=? and idCreator=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, vacancyName);
            preparedStatement.setString(2, vacancyDescription);
            preparedStatement.setString(3, vacancyRequirements);
            preparedStatement.setInt(4, idVacancy);
            preparedStatement.setInt(5, idUser);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVacancy(int idUser, int idVacancy) {
        String query = "DELETE FROM vacancy.vacancy where idvacancy=? and idCreator=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idVacancy);
            preparedStatement.setInt(2, idUser);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
