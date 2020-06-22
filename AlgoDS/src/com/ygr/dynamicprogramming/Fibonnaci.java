package com.ygr.dynamicprogramming;

public class Fibonnaci {

    public static void main(String[] args) {
        Fibonnaci fibonnaci = new Fibonnaci();
        int until = 10;
        fibonnaci.fibonnaci(until);
    }

    int arr[];

    // 1, 1, 2, 3, 5, 8, 13..
    void fibonnaci(int until) {
        this.arr = new int[until];
        this.arr[1] = 1;
        this.arr[2] = 1;
        int i = 3;
        while (i < until) {
            this.arr[i] = this.arr[i - 1] + this.arr[i - 2];
            i++;
        }
        System.out.println(this.arr[until - 1]);
    }
}
