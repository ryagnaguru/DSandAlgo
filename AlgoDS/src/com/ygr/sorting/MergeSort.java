package com.ygr.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int sorted[] = mergeSort.split(new int[]{17, 6, 22, 14, 11, 5, 32, 44, 12, 8, 20});
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }

    int[] split(int arr[]) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int larr[] = split(Arrays.copyOfRange(arr, 0, mid));
            int rarr[] = split(Arrays.copyOfRange(arr, mid, arr.length));
            return merge(larr, rarr);
        }
        return arr;
    }

    int[] merge(int arr1[], int arr2[]) {
        int num[] = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                num[k] = arr2[j];
                j++;
            } else {
                num[k] = arr1[i];
                i++;
            }
            k++;
        }
        while (i < arr1.length) {
            num[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            num[k] = arr2[j];
            j++;
            k++;
        }
        return num;
    }

}
