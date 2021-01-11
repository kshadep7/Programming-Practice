package medium;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(longIncSubseq(arr));
        System.out.println(longIncSubseqDP(arr));
        System.out.println(longIncSubseqBinarySearch(arr));
    }

    // nums = [10,9,2,5,3,7,101,18]
    static int longIncSubseq(int[] arr) {
        return helper(arr, 0, Integer.MIN_VALUE);
    }

    // take it or leave approach
    // TC : 2^n
    // SC: n -> call stack
    private static int helper(int[] arr, int i, int pre) {
        int n = arr.length;
        if (i >= n)
            return 0;
        else if (arr[i] <= pre)
            return helper(arr, i + 1, pre);
        else {
            return Math.max(1 + helper(arr, i + 1, arr[i]), helper(arr, i + 1, pre));
        }
    }


    // DP appraoch
    static int longIncSubseqDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int maxPreviousLen = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    maxPreviousLen = Math.max(maxPreviousLen, dp[j]);
                }
            }
            dp[i] = maxPreviousLen + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    // faster approach
    // TC: nlogn  -> coz of binary search
    static int longIncSubseqBinarySearch(int[] arr) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {          // N
            if (arr[i] <= sequence.get(0))
                sequence.set(0, arr[i]);
            else if (arr[i] > sequence.get(sequence.size() - 1))
                sequence.add(arr[i]);
            else {      // binray search to find next big number index
                sequence.set(getnextBigNumIndex(arr[i], sequence), arr[i]); // logN
            }
        }
        return sequence.size();
    }

    // LogN
    private static int getnextBigNumIndex(int num, List<Integer> sequence) {
        int lo = 0;
        int hi = sequence.size() - 1;

        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            if (num == sequence.get(mid))
                return mid;
            else if (num < sequence.get(mid))
                hi = mid;
            else
                lo = mid;
        }
        return hi;
    }
}
