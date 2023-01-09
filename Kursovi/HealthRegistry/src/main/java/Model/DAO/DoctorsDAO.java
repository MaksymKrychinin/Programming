package Model.DAO;

import Model.DB.DBConnection;
import Model.Entity.Doctor;
import Model.Entity.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorsDAO {


    public void newTime(String doctorName, Time time) {
        String query1 = "INSERT IGNORE INTO time(time) values (?);";
        String query = "INSERT IGNORE INTO doctortime(iddoctor, idtime) " +
                "values((select iddoctors from doctors where doctorsName=?),(select idtime from time where time=?));";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setTime(1, time);
            preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, doctorName);
            preparedStatement.setTime(2, time);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTime(String doctorName, Time time1, Time time2) {
        String query1 = "INSERT IGNORE INTO time(time) values (?);";
        String query = "UPDATE doctortime set idTime=(select idtime from time where time.time=?) " +
                "where iddoctor=(select iddoctors from doctors where doctorsName=?) \n" +
                "and idtime=(select idtime from time where time.time=?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setTime(1, time2);
            preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setTime(1, time2);
            preparedStatement.setString(2, doctorName);
            preparedStatement.setTime(3, time1);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTime(String doctorName, Time time) {
        String query = "DELETE FROM doctortime \n" +
                "where iddoctor=(select iddoctors from doctors where doctorsName=?) \n" +
                "and idTime=(select idtime from time where time=?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, doctorName);
            preparedStatement.setTime(2, time);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> allDoctors() {
        List<Doctor> doctorsList = new ArrayList<>();
        String query = "SELECT iddoctors, doctorsName FROM health_registry.doctors;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Doctor doctor = new Doctor(id, name);
                doctorsList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorsList;
    }

    public void joinInSchedule(int idUser, int idSchedule) {
        String query = "UPDATE doctortime set iduser =? where iddoctortime=?";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setInt(2, idSchedule);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Schedule> scheduleById(int idDoctor) {
        List<Schedule> scheduleList = new ArrayList<>();
        String query = "SELECT iddoctortime, time, iduser FROM health_registry.doctortime dt\n" +
                "INNER JOIN time t on dt.idtime=t.idtime\n" +
                "where dt.iddoctor=? order by time;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idDoctor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Time time = resultSet.getTime(2);
                int idUser = resultSet.getInt(3);
                Schedule schedule = new Schedule(id, time, idUser);
                scheduleList.add(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public void leaveFromSchedule(int userId, int idSchedule) {
        String query = "UPDATE doctortime set iduser =0 where iddoctortime=? and iduser=?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idSchedule);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
