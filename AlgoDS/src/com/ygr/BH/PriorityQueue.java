package com.ygr.BH;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

    List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.performInsertion(priorityQueue);
        priorityQueue.extractMax();
    }

    void extractMax() {
        int root = this.nodes.get(0).priorityValue;
        this.nodes.set(0, this.nodes.get(this.nodes.size() - 1));
        this.nodes.remove(this.nodes.size() - 1);
        int index = 0;

        while (index >= 0) {
            int leftIdx = (2 * index) + 1;
            int rightIdx = (2 * index) + 2;
            Node element = this.nodes.get(index);
            Node leftElement = null;
            if (this.nodes.size() >= leftIdx) {
                leftElement = nodes.get(leftIdx);
            }
            Node rightElement = null;
            if (this.nodes.size() >= rightIdx) {
                rightElement = nodes.get(rightIdx);
            }
            if (leftElement != null && element != null && leftElement.priorityValue > element.priorityValue &&
                    (rightElement != null && rightElement.priorityValue < leftElement.priorityValue)) {
                this.nodes.set(index, leftElement);
                this.nodes.set(leftIdx, element);
                index = leftIdx;
            } else if (element != null && rightElement != null &&
                    rightElement.priorityValue > element.priorityValue) {
                this.nodes.set(index, rightElement);
                this.nodes.set(rightIdx, element);
                index = rightIdx;
            } else {
                index = -1;
            }
        }
        System.out.println(this.nodes);
        System.out.println("root - " + root);
    }

    void insertNode(Node value) {
        this.nodes.add(value);
        int insertIdx = this.nodes.size() - 1;
        while (insertIdx > 0) {
            Node element = nodes.get(insertIdx);
            int parentIdx = (int) Math.floor((insertIdx - 1) / 2);
            Node parentElement = nodes.get(parentIdx);
            if (parentElement.priorityValue < element.priorityValue) {
                this.nodes.set(insertIdx, parentElement);
                this.nodes.set(parentIdx, element);
                insertIdx = parentIdx;
            } else {
                break;
            }
        }
    }

    private void performInsertion(PriorityQueue priorityQueue) {
        priorityQueue.insertNode(new Node(50));
        priorityQueue.insertNode(new Node(49));
        priorityQueue.insertNode(new Node(48));
        priorityQueue.insertNode(new Node(47));
        priorityQueue.insertNode(new Node(45));
        priorityQueue.insertNode(new Node(6));
        priorityQueue.insertNode(new Node(44));
        priorityQueue.insertNode(new Node(43));
        priorityQueue.insertNode(new Node(42));
        priorityQueue.insertNode(new Node(41));
        priorityQueue.insertNode(new Node(40));
        priorityQueue.insertNode(new Node(39));
        priorityQueue.insertNode(new Node(38));
        priorityQueue.insertNode(new Node(37));
        priorityQueue.insertNode(new Node(36));
        System.out.println(priorityQueue.nodes);
    }

    class Node {
        String desc = "";
        int priorityValue;

        Node(String desc, int priorityValue) {
            this.desc = desc;
            this.priorityValue = priorityValue;
        }

        Node(int priorityValue) {
            this.desc = priorityValue + "";
            this.priorityValue = priorityValue;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "desc='" + desc + '\'' +
                    ", priorityValue=" + priorityValue +
                    '}';
        }
    }
}
