package com.ygr.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Node root;

    public static void main(String[] args) {
        BST bst = new BST();
        bst.performInsertion(bst);
//        bst.findNode(42);
//        bst.BFS();
//        bst.inorder();
//        bst.preOrder();
        bst.postOrder();
        System.out.println(bst.root);
    }

    void postOrder() {
        Node node = this.root;
        Queue<Integer> data = new LinkedList<>();
        postorderTraverse(data, node);
        System.out.println(data);
    }

    void postorderTraverse(Queue<Integer> data, Node node) {
        if (node.right != null) postorderTraverse(data, node.right);
        if (node.left != null) postorderTraverse(data, node.left);
        if (node != null) {
            data.add(node.value);
        }
    }

    void preOrder() {
        Node node = this.root;
        Queue<Integer> data = new LinkedList<>();
        preorderTraverse(data, node);
        System.out.println(data);
    }

    void preorderTraverse(Queue<Integer> data, Node node) {
        if (node != null) {
            data.add(node.value);
        }
        if (node.right != null) preorderTraverse(data, node.right);
        if (node.left != null) preorderTraverse(data, node.left);
    }

    void inorder() {
        Node node = this.root;
        Queue<Integer> data = new LinkedList<>();
        inorderTraverse(data, node);
        System.out.println(data);
    }

    void inorderTraverse(Queue<Integer> data, Node node) {
        if (node.right != null) inorderTraverse(data, node.right);
        if (node != null) {
            data.add(node.value);
        }
        if (node.left != null) inorderTraverse(data, node.left);
    }

    void insert(int value) {
        this.root = insertRec(this.root, value);
    }

    Node insertRec(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (node.value > value) {
            node.right = insertRec(node.right, value);
        } else {
            node.left = insertRec(node.left, value);
        }
        return node;
    }

    void BFS() {
        Queue<Node> arr = new LinkedList<>();
        Queue<Integer> data = new LinkedList<>();

        Node node = this.root;
        if (node != null) arr.offer(node);
        while (!arr.isEmpty()) {
            node = arr.poll();
            data.offer(node.value);
            if (node.left != null) arr.offer(node.left);
            if (node.right != null) arr.offer(node.right);
        }
        System.out.println(data);
    }

    Node findNode(int value) {
        Node node = this.root;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            if (node.value > value) node = node.right;
            else node = node.left;
        }

        return null;
    }

    void performInsertion(BST bst) {

        /**
         *            50
         *         /     \
         *        40      60
         *       / \     / \
         *     39   42  55  62
         *
         */
        bst.insert(50);
        bst.insert(60);
        bst.insert(55);
        bst.insert(40);
        bst.insert(42);
        bst.insert(39);
        bst.insert(62);
        System.out.println(bst.root);
    }

    class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", right=" + right +
                    ", left=" + left +
                    '}';
        }
    }
}
