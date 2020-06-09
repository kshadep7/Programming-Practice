package easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0}; // 1 2 3 3 5 6
        int[] arr2 = {2, 5, 6};

        merge(arr1, 3, arr2, 2);


    }

    static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }
        System.out.println(Arrays.toString(arr1));

        while (k >= 0 && j >= 0) {
            arr1[k--] = arr2[j--];
        }

        System.out.println(Arrays.toString(arr1));
    }
}
