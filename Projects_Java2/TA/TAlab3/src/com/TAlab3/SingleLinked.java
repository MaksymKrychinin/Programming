package com.TAlab3;

public class SingleLinked<T> implements ListConn<T>{
    int length = 0;
    Node root;


    public void deleteOnIndex(int index) {
        root.deleteOnIndex(index);
    }

    public void deleteOnStart() {
        root.deleteOnStart();
    }

    public void deleteOnEnd() {
        root.deleteOnEnd();
    }

    public int indexOfElement(T element) {
        return root.indexSearcher(element, 0);
    }

    public void addOnStart(T element) {
        if (length == 0) {
            root = new Node(element);
        } else {
            Node tmp = new Node(element);
            tmp.next = root;
            root = tmp;
        }
    }

    public void addOnEnd(T element) {
        if (length == 0) {
            root = new Node(element);
        } else {
            root.addOnEnd(element);
        }
    }

    public void addOnIndex(T element, int index) {
        if (root == null & index != 0) {
            throw new IndexOutOfBoundsException();
        } else if (root == null & index == 0) {
            root = new Node(element);
        } else {
            root.validIndex(element, index);
        }
    }

    class Node {
        T current;
        Node next = null;

        Node(T current) {
            this.current = current;
            length++;

        }

        void addOnEnd(T element) {
            if (next == null) {
                next = new Node(element);
            } else {
                next.addOnEnd(element);
            }
        }


        public void validIndex(T element, int index) {
            if (index == length) {
                root.addOnEnd(element);
            } else if (index == 0) {
                addOnStart(element);
            } else if (index <= length & index > 0) {
                root.addOnIndex(element, index);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        private void addOnIndex(T element, int index) {
            index--;
            if (index == 0) {
                Node tmp = new Node(element);
                tmp.next = next;
                next = tmp;
            } else {
                next.addOnIndex(element, index);
            }
        }

        void deleteOnIndex(int index) {
            if (index > length - 1 | index < 0) {
                throw new IndexOutOfBoundsException();
            } else {
                index--;
                if (index != 0) {
                    next.deleteOnIndex(index);
                } else {
                    next = next.next;
                    length--;
                }
            }
        }

        void deleteOnStart() {
            root = root.next;
            length--;
        }

        void deleteOnEnd() {
            if (next == null) {
                current = null;
                length--;
            } else if (next.next == null) {
                next = null;
                length--;
            } else {
                next.deleteOnEnd();
            }
        }

        public int indexSearcher(T element, int index) {
            if (current.equals(element)) {
                return index;
            } else if (next != null) {
                return (next.indexSearcher(element, index + 1));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}

