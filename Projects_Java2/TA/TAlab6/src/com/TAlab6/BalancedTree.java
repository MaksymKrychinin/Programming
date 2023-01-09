package com.TAlab6;

public class BalancedTree {
    private class Leaf {
        int key;
        int height;
        Leaf left;
        Leaf right;

        Leaf(int key) {
            this.key = key;
        }
    }

    private Leaf root;

    public Leaf find(int key) {
        Leaf current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Leaf insert(Leaf leaf, int key) {
        if (leaf == null) {
            return new Leaf(key);
        } else if (leaf.key > key) {
            leaf.left = insert(leaf.left, key);
        } else if (leaf.key < key) {
            leaf.right = insert(leaf.right, key);
        }
        return rebalance(leaf);
    }

    private Leaf delete(Leaf leaf, int key) {
        if (leaf == null) {
            return leaf;
        } else if (leaf.key > key) {
            leaf.left = delete(leaf.left, key);
        } else if (leaf.key < key) {
            leaf.right = delete(leaf.right, key);
        } else {
            if (leaf.left == null || leaf.right == null) {
                leaf = (leaf.left == null) ? leaf.right : leaf.left;
            } else {
                Leaf mostLeftChild = mostLeftChild(leaf.right);
                leaf.key = mostLeftChild.key;
                leaf.right = delete(leaf.right, leaf.key);
            }
        }
        if (leaf != null) {
            leaf = rebalance(leaf);
        }
        return leaf;
    }

    private Leaf mostLeftChild(Leaf leaf) {
        Leaf current = leaf;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Leaf rebalance(Leaf leaf) {
        updateHeight(leaf);
        int balance = getBalance(leaf);
        if (balance > 1) {
            if (height(leaf.right.right) > height(leaf.right.left)) {
                leaf = rotateLeft(leaf);
            } else {
                leaf.right = rotateRight(leaf.right);
                leaf = rotateLeft(leaf);
            }
        } else if (balance < -1) {
            if (height(leaf.left.left) > height(leaf.left.right)) {
                leaf = rotateRight(leaf);
            } else {
                leaf.left = rotateLeft(leaf.left);
                leaf = rotateRight(leaf);
            }
        }
        return leaf;
    }

    private Leaf rotateRight(Leaf y) {
        Leaf x = y.left;
        Leaf z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Leaf rotateLeft(Leaf y) {
        Leaf x = y.right;
        Leaf z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Leaf n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Leaf n) {
        return n == null ? -1 : n.height;
    }

    private int getBalance(Leaf n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
}