package Entity;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    String queueName;
    int idQueue;
    String creator;

    public int getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(int idCreator) {
        this.idCreator = idCreator;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    int idCreator;
    List<User> list;
    boolean status;


    public Queue() {
        list = new ArrayList<User>();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public int getIdQueue() {
        return idQueue;
    }

    public void setIdQueue(int idQueue) {
        this.idQueue = idQueue;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<User> getList() {
        return list;
    }

    public void addToList(User user) {
        this.list.add(user);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Queue(String queueName, int idQueue, String creator, boolean status, int idCreator) {
        this.queueName = queueName;
        this.idQueue = idQueue;
        this.creator = creator;
        this.list = new ArrayList<>();
        this.status = status;
        this.idCreator=idCreator;
    }

    public Queue(int idQueue, String queueName, String creator) {
        this.idQueue = idQueue;
        this.queueName = queueName;
        this.creator = creator;
    }

}
