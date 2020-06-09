package easy;

import java.util.Arrays;

public class TwoSumLessThanK {

    public static void main(String[] args) {
        int[] arr = {34, 23, 1, 24, 75, 33, 54, 8};
        System.out.println(twoSum1(arr, 60));
    }

    // brute force
    // n^2
    static int twoSum(int[] arr, int k) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] < k)
                    ans = Math.max(ans, arr[i] + arr[j]);
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
    // when sorted use two pointer approach on already sorted array
    static int twoSum1(int[] arr, int k) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < k) {
                ans = Math.max(ans, sum);
                i++;
            } else j--;

        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

}
