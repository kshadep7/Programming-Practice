package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 6, 8, 5, 3, 7};
        int[][] arr1 = {{3, 4}, {1, 6}, {7, 1}, {1, 8}, {1, 3}};
//        sort(arr);
        System.out.println(Arrays.deepToString(arr1));
        Arrays.parallelSort(arr1, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(arr1));
    }

    // TC: nlogn -> worst case
    // SC: n -> arrays left and right
    static void sort(int[] arr) {
        if (arr.length < 2)
            return;
        int l = 0;
        int r = arr.length;
        int mid = l + (r - l) / 2;
        int[] left = new int[mid];
        int[] right = new int[r - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

//        System.out.println(Arrays.toString(left));
        sort(left);
//        System.out.println(Arrays.toString(right));
        sort(right);
        mergeSortedArr(left, right, arr);
    }

    private static void mergeSortedArr(int[] left, int[] right, int[] arr) {
        int ln = left.length;
        int rn = right.length;
        int i = 0, j = 0, k = 0;
        while (i < ln && j < rn) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else
                arr[k++] = right[j++];
        }
        while (i < ln)
            arr[k++] = left[i++];
        while (j < rn)
            arr[k++] = right[j++];
    }
}
