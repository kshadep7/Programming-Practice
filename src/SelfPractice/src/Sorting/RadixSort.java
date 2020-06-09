package Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {20, 57, 100, 39, 52, 1};
        radix(arr);
    }

    //uses count sort as sub sorting algorithm
    //only diff is radix deals with the digit places (10th's , 100th's, etc.) and then does count sort using
    //those digits.

    static void radix(int[] arr) {

        int max = getMax(arr);
        // to take digits of a item in arr
        for (int i = 1; max / i > 0; i *= 10) {
//            System.out.println("==========================");
            helper(arr, i);
        }

        System.out.println("Sorted Array -->  " + Arrays.toString(arr));
    }

    // arr ->  20, 57, 100, 39, 52, 1
    //          *   *    *   *   *  *
    static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }

    // count sort
    static void helper(int[] arr, int place) {
        int[] count = new int[10];
        int[] out = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / place) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            out[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = out[i];
        }
        System.out.println(Arrays.toString(arr));
    }

}
