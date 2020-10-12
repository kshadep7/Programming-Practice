package medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    public static void main(String[] args) {

        int[] arr = {23, 2, 4, 6, 7};
//        System.out.println(check(arr, 6));
        System.out.println(check1(arr, 6));

    }

    static boolean check(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int sum = 0;
                for (int l = i; l < j; l++) {
                    sum += arr[l];
                    if (sum == k || k != 0 && sum % k == 0)
                        return true;
                }

            }

        }
        return false;
    }

    // using hash map
    // idea is to check for reminder in the map and curr reminder and found reminder in the map should be
    // 1 or more indexes apart
    static boolean check1(int[] arr, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (k != 0)
                sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

}
