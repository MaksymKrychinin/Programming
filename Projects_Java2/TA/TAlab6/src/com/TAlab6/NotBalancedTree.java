package com.TAlab6;

public class NotBalancedTree {
    private Leaf root;

    NotBalancedTree() {
        root = null;
    }

    public void insert(int param) {
        root = insertByLeaf(param, root);
    }

    private Leaf insertByLeaf(int param, Leaf root) {
        if (root == null) {
            root = new Leaf(param);
            return root;
        }
        if (param < root.current) {
            root.left = insertByLeaf(param, root.left);
        } else if (param > root.current) {
            root.right = insertByLeaf(param, root.right);
        }
        return root;
    }

    public void deleteKey(int param) {
        root = deleteRec(root, param);
    }

    private Leaf deleteRec(Leaf root, int param) {
        if (root == null) {
            return root;
        }
        if (param < root.current) {
            root.left = deleteRec(root.left, param);
        } else if (param > root.current) {
            root.right = deleteRec(root.right, param);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.current = minValue(root.right);

            root.right = deleteRec(root.right, root.current);
        }
        return root;
    }

    private int minValue(Leaf root) {
        int minv = root.current;
        while (root.left != null) {
            minv = root.left.current;
            root = root.left;
        }
        return minv;
    }

    public Leaf search(int param) {
        Leaf temp = searchByLeaf(root, param);
        if (temp == null) {
            return null;
        } else
            return searchByLeaf(root, param);
    }

    private Leaf searchByLeaf(Leaf root, int param) {
        if (root == null) {
            return root;
        }
        if (root.current == param) {
            return root;
        }
        if (param < root.current) {
            root = searchByLeaf(root.left, param);
        } else if (param > root.current) {
            root = searchByLeaf(root.right, param);
        }
        return root;
    }

    private class Leaf {
        int current;
        Leaf right, left;

        Leaf(int current) {
            this.current = current;
            right = left = null;
        }
    }
}
