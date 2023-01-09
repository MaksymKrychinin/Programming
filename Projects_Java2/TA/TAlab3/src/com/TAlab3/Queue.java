package com.TAlab3;

class QNode {
    protected int key;
    QNode next;

    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

class Queue {
    QNode front, rear;

    public Queue() {
        this.front = this.rear = null;
    }


    void add(int key) {

        QNode temp = new QNode(key);

        if (this.rear == null) {
            this.front = this.rear = temp;
        }
        //додає новий елемент в кінець черги і змінює задній
        this.rear.next = temp;
        this.rear = temp;
    }

    void delete() {
        if (this.front == null) {
            return;
        }
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }
    }

    int get() {
        return this.front.key;
    }

    void display() {
        if (this.front == null) {
            return;
        } else {
            while (this.front != null) {
                System.out.printf("<-%d", this.front.key);
                this.front = this.front.next;
            }
        }
    }
}
