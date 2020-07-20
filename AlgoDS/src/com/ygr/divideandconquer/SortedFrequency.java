package com.ygr.divideandconquer;

/**
 * Given a sorted array and a number, write a function called
 * sortedFrequency that counts the
 * occurences of the number in the array.
 */
public class SortedFrequency {

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 8};
        int item = 1;

        int index = -1;

        int right = arr.length;
        int left = 0;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == item) {
                index = mid;
                break;
            }
            if (arr[mid] < item) {
                left = mid;
            } else {
                right = mid;
            }
        }

        int count = 0;
        left = index - 1;
        right = index;
        while (left >= 0 && arr[left] == item) {
            count++;
            left--;
        }

        while (right < arr.length && arr[right] == item) {
            count++;
            right++;
        }
        System.out.println(count);
    }
}
