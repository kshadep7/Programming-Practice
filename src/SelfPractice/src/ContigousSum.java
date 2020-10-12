import java.util.Arrays;

public class ContigousSum {
    /*
    * Given a list of integers and a number K, return which contiguous elements of the list sum to K.
    For example, if the list is [1, 2, 3, 4, 5] and K is 9, then
    * it should return [2, 3, 4], since 2 + 3 + 4 = 9.
*/

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {34, -50, 42, 14, -5, 86};
        int[] arr2 = {-5, -1, -8, -9};
//        System.out.println(Arrays.toString(findSubarray(arr, 9)));
        System.out.println(Arrays.toString(getMaxSum(arr1)));
    }

    // brute force
    static int[] findSubarray(int[] arr, int k) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            int currSum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (currSum > k)
                    break;
                else if (currSum == k) {
                    start = i;
                    end = j;
                } else
                    currSum += arr[j];
            }
        }
        int len = end - start + 1;
        int[] res = new int[len];
        for (int j = start; j < len; j++) {
            res[j] = arr[j];
        }
        return res;
    }

    //  similar problem
/*
    Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
    For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137,
    since we would take elements 42, 14, -5, and 86.

    Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
    Do this in O(N) time.
*/
    static int[] getMaxSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int[0];
        int start = 0, end = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSum += arr[i];
            if (maxSum < 0) {
                maxSum = 0;
                start = i+1;
            } else {
                end = i;
            }
        }
        int len = end - start + 1;
        len = Math.max(len, 0);
        int[] res = new int[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            res[i] = arr[start++];
        }
        return res;
    }
}
