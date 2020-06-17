package com.ygr.BH;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeapMax {
    List<Integer> nodes = new ArrayList<>();

    public static void main(String[] args) {
        BinaryHeapMax binaryHeap = new BinaryHeapMax();
        performInsertion(binaryHeap);
        binaryHeap.extractMax();
    }

    void extractMax() {
        int root = this.nodes.get(0);
        this.nodes.set(0, this.nodes.get(this.nodes.size() - 1));
        this.nodes.remove(this.nodes.size() - 1);
        int index = 0;

        while (index >= 0) {
            int leftIdx = (2 * index) + 1;
            int rightIdx = (2 * index) + 2;
            int element = this.nodes.get(index);
            int leftElement = -1;
            if (this.nodes.size() >= leftIdx) {
                leftElement = nodes.get(leftIdx);
            }
            int rightElement = -1;
            if (this.nodes.size() >= rightIdx) {
                rightElement = nodes.get(rightIdx);
            }
            if (leftElement > element && (rightElement != -1 && rightElement < leftElement)) {
                this.nodes.set(index, leftElement);
                this.nodes.set(leftIdx, element);
                index = leftIdx;
            } else if (rightElement != -1 && rightElement > element) {
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

    void insertNode(int value) {
        this.nodes.add(value);
        int insertIdx = this.nodes.size() - 1;
        while (insertIdx > 0) {
            int element = nodes.get(insertIdx);
            int parentIdx = (int) Math.floor((insertIdx - 1) / 2);
            int parentElement = nodes.get(parentIdx);
            if (parentElement < element) {
                this.nodes.set(insertIdx, parentElement);
                this.nodes.set(parentIdx, element);
                insertIdx = parentIdx;
            } else {
                break;
            }
        }
    }

    private static void performInsertion(BinaryHeapMax binaryHeap) {
        binaryHeap.insertNode(50);
        binaryHeap.insertNode(49);
        binaryHeap.insertNode(48);
        binaryHeap.insertNode(47);
        binaryHeap.insertNode(46);
        binaryHeap.insertNode(45);
        binaryHeap.insertNode(44);
        binaryHeap.insertNode(43);
        binaryHeap.insertNode(42);
        binaryHeap.insertNode(41);
        binaryHeap.insertNode(40);
        binaryHeap.insertNode(39);
        binaryHeap.insertNode(38);
        binaryHeap.insertNode(37);
        binaryHeap.insertNode(36);
        System.out.println(binaryHeap.nodes);
    }
}
