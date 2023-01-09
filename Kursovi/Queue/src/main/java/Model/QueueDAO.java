package Model;

import Entity.Queue;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueueDAO {

    public List<Queue> actualQueues() {
        List<Queue> queueList = new ArrayList<>();
        String query = "SELECT q.idqueue, q.queueName, u.username FROM queue.queues q\n" +
                "INNER JOIN queue.users u ON q.idCreator=u.idusers;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String creator = resultSet.getString(3);
                Queue queue = new Queue(id, name, creator);
                queueList.add(queue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queueList;
    }

    public Queue getQueueById(int id) {
        Queue queue = null;
        String query1 = "SELECT qs.idqueue, qs.queueName, IF(qs.status, 'true','false'), \n" +
                "username, qs.idCreator\n" +
                "FROM queue.queues qs\n" +
                "INNER JOIN queue.users u ON qs.idCreator=u.idusers where qs.idqueue=?\n" +
                "and qs.idqueue=? limit 1;";
        String query2 = "SELECT u.idusers, u.username FROM queue.queueusers q\n" +
                "inner join queue.queues qs ON q.idqueue=qs.idqueue\n" +
                "inner join queue.users u ON q.idUser=u.idusers\n" +
                "where q.idqueue=?\n" +
                "order by q.numberInQueue;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setInt(1, id);
            preparedStatement1.setInt(2, id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            int idQueue = resultSet.getInt(1);
            String queueName = resultSet.getString(2);
            boolean status = resultSet.getBoolean(3);
            String creatorName = resultSet.getString(4);
            int idCreator = resultSet.getInt(5);
            queue = new Queue(queueName, idQueue, creatorName, status, idCreator);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, id);
            resultSet = preparedStatement2.executeQuery();
            for (int i = 1; resultSet.next(); i++) {
                int idUser = resultSet.getInt(1);
                String username = resultSet.getString(2);
                User user = new User(idUser, username, i);
                queue.addToList(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queue;
    }

    public void deleteFromQueueById(int queueId, int idUser) {
        String query = "DELETE FROM queue.queueusers where idqueue = ? and idUser = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, queueId);
            preparedStatement.setInt(1, idUser);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queueNext(int queueId) {
        String query = "DELETE FROM queue.queueusers where idqueue = ? order by numberInQueue limit 1;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, queueId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openClose(int queueId, int status) {
        String query = "UPDATE queue.queues SET status = ? where idqueue = ?;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, queueId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createQueue(String queueName, int idCreator) {
        String query = "INSERT IGNORE INTO queue.queues(queueName, idCreator) VALUES(?, ?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, queueName);
            preparedStatement.setInt(2, idCreator);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int joinQueue(int idQueue, int idCurrentUser) {
        String query = "INSERT IGNORE INTO queueusers(idqueue, idUser, numberInQueue)\n" +
                "select ?, ?, if(numberInQueue is null, 1, numberInQueue+1) FROM queueusers order by numberInQueue desc limit 1;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idQueue);
            preparedStatement.setInt(2, idCurrentUser);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idQueue;
    }
}
