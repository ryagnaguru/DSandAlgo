package com.ygr;

public class FindMinInRotatedArr {

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 1, 2, 3, 4};
        int search = 5;

        System.out.println(findMin(arr));
        ;
    }

    /**
     * 0+6 / 2= 3
     * 1+6 /2 =
     *
     * @param arr
     * @return
     */
    private static int findMin(int arr[]) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }
}
