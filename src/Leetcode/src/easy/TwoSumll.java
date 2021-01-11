package easy;

import java.util.Arrays;

public class TwoSumll {

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSumll(arr, 9)));
    }

    // N
    static int[] twoSumll(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == target)
                return new int[]{lo + 1, hi + 1};
            else if (sum < target)
                lo++;
            else
                hi--;
        }
        return new int[]{-1, -1};
    }
}
