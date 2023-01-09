package DAO;

import DataBaseConnectionPool.ConnectionPool;
import Entity.Task;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    private String ALL_TASK = "SELECT * FROM projectmanagment.task;";
    private String TASK_BY_DESCRIPTION = "SELECT * FROM projectmanagment.task where description LIKE CONCAT('%',?,'%');";
    private String EDIT_TASK = "UPDATE projectmanagment.task SET name=?, description=? where idtask=?;";
    private String DELETE_TASK = "DELETE FROM projectmanagment.task where idtask=?;";
    private String ALL_USER_TASK = "SELECT * FROM projectmanagment.task where idUser=?;";
    private String ADD_TASK = "INSERT INTO projectmanagment.task(name, description, idUser) VALUES(?,?,?);";

    public List<Task> allTask() {
        List<Task> taskList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_TASK)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTask = resultSet.getInt("idtask");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int idUser = resultSet.getInt("idUser");
                Task task = new Task(idTask, name, idUser, description);
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public List<Task> userTasks(User user) {
        List<Task> taskList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_USER_TASK)) {
            preparedStatement.setInt(1, user.getIdUser());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTask = resultSet.getInt("idtask");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int idUser = resultSet.getInt("idUser");
                Task task = new Task(idTask, name, idUser, description);
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public List<Task> taskByDescription(String PartDescription) {
        List<Task> taskList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(TASK_BY_DESCRIPTION)) {
            preparedStatement.setString(1, PartDescription);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTask = resultSet.getInt("idtask");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int idUser = resultSet.getInt("idUser");
                Task task = new Task(idTask, name, idUser, description);
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public boolean editTask(Task task) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_TASK)) {
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, task.getId());
            return preparedStatement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTask(int id) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TASK)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addTask(Task task) {
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_TASK)) {
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setInt(3, task.getIdUser());
            return preparedStatement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
