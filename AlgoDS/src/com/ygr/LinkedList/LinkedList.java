package com.ygr.LinkedList;

public class LinkedList {

    Node head;
    Node tail;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        System.out.println(linkedList.head);
        linkedList.insert(9, 1);
        System.out.println(linkedList.head);
        linkedList.insert(22, 3);
        System.out.println(linkedList.head);
        linkedList.insert(33, 4);
        System.out.println(linkedList.head);
        linkedList.delete(1);
        System.out.println(linkedList.head);
        linkedList.delete(4);
        System.out.println(linkedList.head);
    }

    void delete(int position) {
        if (position == 0) {
            if (this.head.next != null) {
                this.head = this.head.next;
            }
        } else {
            Node currentNode = this.head;
            int counter = 0;
            while (currentNode.next != null) {
                Node prevNode = currentNode;
                Node currentNextNode = currentNode.next;
                currentNode = currentNextNode;
                counter++;
                if (counter == position) {
                    prevNode.next = currentNode.next;
                }
            }
        }

    }

    void insert(int value, int position) {
        if (position == 0) {
            if (this.head == null) {
                this.add(value);
                return;
            }
            Node newHead = new Node(value);
            newHead.next = this.head;
            this.head = newHead;
            return;
        }
        int counter = 0;
        Node currentNode = this.head;
        boolean inserted = false;
        Node newNode = new Node(value);
        while (currentNode != null) {
            counter++;
            if (counter == position) {
                Node currentNext = currentNode.next;
                currentNode.next = newNode;
                newNode.next = currentNext;
                inserted = true;
                break;
            }
            currentNode = currentNode.next;
        }
        if (!inserted) {
            counter = 0;
            currentNode = this.head.next;
            while (currentNode != null) {
                counter++;
                currentNode = currentNode.next;
            }
            if (position == counter + 1) {
                this.tail.next = newNode;
                this.tail = newNode;
                inserted = true;
            }
            if (!inserted)
                System.out.println("invalid position");
        }
    }

    void add(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }


}
