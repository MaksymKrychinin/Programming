package com.TAlab3;

public class DoubleLinked<T> implements ListConn<T> {
    int length = 0;
    Node root = null;
    Node last = null;

    public void addOnEnd(T element) {
        if (root == null) {
            root = new Node(element);
            last = root;
        } else {
            last.addOnEnd(element);
        }
    }

    public void addOnStart(T element) {
        if (root == null) {
            root = new Node(element);
            last = root;
        } else {
            root.addOnStart(element);
        }
    }

    public void addOnIndex(T element, int index) {
        if (root == null & index != 0) {
            throw new IndexOutOfBoundsException();
        } else if (root == null & index == 0) {
            root = new Node(element);
            last = root;
        } else {
            root.validIndexAdd(element, index);
        }
    }

    public void deleteOnIndex(int index) {
        if (index < length / 2) {
            root.validIndexDel(index);
        } else {
            last.validIndexDel(index);
        }
    }

    public void deleteOnStart() {
        root.deleteOnStart();
    }

    public void deleteOnEnd() {
        last.deleteOnEnd();
    }

    public int indexOfElement(T element) {
        return root.indexSearcher(element, 0);
    }

    class Node {
        Node prev = null;
        T current;
        Node next = null;

        Node(T element) {
            this.current = element;
            length++;
        }

        void addOnEnd(T element) {
            if (next == null) {
                next = new Node(element);
                next.prev = this;
                last = next;
            } else {
                next.addOnEnd(element);
            }
        }

        void addOnStart(T element) {
            prev = new Node(element);
            prev.next = root;
            root = prev;
        }

        void addOnIndexFromRoot(T element, int index) {
            if (index == 0) {
                Node tmp = new Node(element);
                tmp.prev = this;
                tmp.next = next;
                next.prev = tmp;
                next = tmp;
            } else {
                index--;
                next.addOnIndexFromRoot(element, index);
            }

        }

        void addOnIndexFromLast(T element, int index) {
            index++;
            if (length - index == 0) {
                Node tmp = new Node(element);
                prev.next = tmp;
                tmp.prev = prev;
                prev = tmp;
                tmp.next = this;
            } else {
                prev.addOnIndexFromLast(element, index);
            }

        }


        int indexSearcher(T element, int index) {
            if (current.equals(element)) {
                return index;
            } else if (next != null) {
                return (next.indexSearcher(element, index + 1));
            } else {
                throw new IllegalArgumentException();
            }
        }

        void deleteOnIndexRoot(int index) {
            if (index > length - 1 | index < 0) {
                throw new IndexOutOfBoundsException();
            } else {
                if (index != 0) {
                    index--;
                    next.deleteOnIndexRoot(index);
                } else {
                    if (next != null) {
                        prev.next=next;
                        next.prev=prev;
                    } else {
                        next = null;
                    }
                    length--;
                }
            }
        }

        void deleteOnIndexLast(int index) {
            if (index > length - 1 | index < 0) {
                throw new IndexOutOfBoundsException();
            } else {
                if (length - index-1 == 0) {
                   prev.next=next;next.prev=prev;
                    length--;
                } else {
                    index++;
                    prev.deleteOnIndexLast(index);

                }
            }
        }

        void deleteOnStart() {
            root = root.next;
            next.prev = null;
            length--;
        }

        void deleteOnEnd() {
            last=prev;
            prev.next=null;
            length--;
        }

        void validIndexAdd(T element, int index) {
            if (index == length) {
                root.addOnEnd(element);
            } else if (index == 0) {
                root.addOnStart(element);
            } else if (index <= length & index > 0) {
                if (index <= length / 2) {
                    root.addOnIndexFromRoot(element, index);
                } else {
                    last.addOnIndexFromLast(element, index);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        void validIndexDel(int index) {
            if (index == length) {
                root.deleteOnEnd();
            } else if (index == 0) {
                root.deleteOnStart();
            } else if (index <= length & index > 0) {
                if (index <= length / 2) {
                    root.deleteOnIndexRoot(index);
                } else {
                    last.deleteOnIndexLast(index);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

}