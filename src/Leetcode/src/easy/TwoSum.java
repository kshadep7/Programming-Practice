package easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {3, 4, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(Arrays.toString(twoSum(arr, 13)));
    }

    // return indices of the numbers adding to k
    static int[] twoSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int compliment = k - arr[i];
            if (map.containsKey(compliment))
                return new int[]{i, map.get(compliment)};
            map.put(arr[i], i);
        }
        return new int[2];
    }
}
