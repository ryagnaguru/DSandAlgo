package com.ygr.divideandconquer;

public class CountZero {

    /**
     * given an array of 1s and 0s which has all 1s first followed by all zeros,
     * writea a funcion called countzeroes, which returns the number of
     * zeroes in the array
     *
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 0, 0, 0};
        int right = 0;
        int left = arr.length;
        int count = 0;

        if (arr[0] != 1) {
            count = arr.length;
        } else if (arr[arr.length - 1] != 0) {
            count = 0;
        } else
            while (right < left) {
                int mid = (right + left) / 2;
                if (arr[mid] == 0) {
                    if (arr[mid - 1] != 0) {
                        count = arr.length - mid;
                        break;
                    } else {
                        left = mid - 1;
                    }
                } else if (arr.length > mid + 1 && arr[mid + 1] == 0) {
                    count = arr.length - (mid + 1);
                    break;
                } else {
                    right = mid + 1;
                }
            }
        System.out.println(count);
    }
}
