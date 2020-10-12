package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pIndex = partition1(arr, lo, hi);
            sort(arr, lo, pIndex - 1);
            sort(arr, pIndex + 1, hi);
        }
    }

/*
    static int partition(int[] arr, int lo, int hi) {
        int i = lo - 1;
        int pivot = arr[hi];
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, hi);
        return i + 1;
    }
*/

    static int partition1(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int pIndex = lo;

        for (int i = lo; i < hi; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, hi);
        return pIndex;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
