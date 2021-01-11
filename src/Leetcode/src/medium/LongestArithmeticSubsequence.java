package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 2, 10};
        int[] arr1 = {83, 20, 17, 43, 52, 78, 68, 45};

        System.out.println(longestArithSeqLength(arr));
        System.out.println(longestArithSeqLength(arr1));
    }

    //TC: n3
    public static int longestArithSeqLength(int[] A) {
        int n = A.length;
        int res = 2;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {    // n
            for (int j = i + 1; j < A.length; j++) {    // n
                int diff = A[j] - A[i];
                if (map.containsKey(diff)) {
                    int[] curr = map.get(diff);
                    curr[j] = curr[i] + 1;
                    res = Math.max(res, curr[j]);
                    map.put(diff, curr);
                } else {
                    int[] arr = new int[n];
                    Arrays.fill(arr, 1); // n
                    arr[j]++;
                    map.put(diff, arr);
                }
            }
        }
        return res;
    }
}
