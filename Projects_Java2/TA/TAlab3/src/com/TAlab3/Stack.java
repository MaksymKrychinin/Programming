package com.TAlab3;


import java.util.EmptyStackException;

class Stack {

    private static class Node {
        int param;
        Node next;
    }

    Node node;

    Stack() {
        this.node = null;
    }

    public void add(int x) {
        Node temp = new Node();

        temp.param = x;
        temp.next = node;
        node = temp;
    }

    public boolean isEmpty() {
        return node == null;
    }

    public int get() {
        if (!isEmpty()) {
            return node.param;
        } else {
            throw new EmptyStackException();
        }
    }

    public void delete() {
        if (node == null) {
            return;
        }
        node = node.next;
    }

    public void display() {
        if (node == null) {
            return;
        } else {
            Node temp = node;
            while (temp != null) {
                System.out.printf("<-%d", temp.param);
                temp = temp.next;
            }
        }
    }
}


