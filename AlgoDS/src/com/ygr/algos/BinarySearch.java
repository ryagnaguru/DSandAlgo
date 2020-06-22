package com.ygr.algos;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
    }

    int binarySearch(int arr[], int search) {
        if (arr.length == 1) {
            if (arr[0] == search) {
                return arr[0];
            } else {
                return -1;
            }
        }
        int mid = arr.length / 2;
        if (arr[mid] == search) {
            return arr[mid];
        }
        if (arr.length > 0 && arr[mid] > search) {
            return binarySearch(Arrays.copyOfRange(arr, 0, mid), search);
        } else if (arr.length > 0) {
            return binarySearch(Arrays.copyOfRange(arr, mid, arr.length), search);
        }
        return -1;
    }
}
