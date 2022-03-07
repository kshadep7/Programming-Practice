package medium;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
//        System.out.println(subArraySum(arr, 6));
//        System.out.println(sumEqual(arr, 3));
        System.out.println(sum(arr, 3));
    }

    // two pointer doesn't work
    static int subArraySum(int[] arr, int k) {
        int count = 0;
        a:
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            if (sum == k) {
                count++;
                continue a;
            }
            b:
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    i = j;
                    count++;
                    break b;
                } else if (sum < k) {
                    continue b;
                } else {
                    i = j;
                    break b;
                }
            }
        }
        return count;
    }

    // using cumulative sum in hash map and then -->
    // is (sum-k) is in map if yes then sub array of sum k is there
    // TC : O(n) SC: O(n)
    static int sumEqual(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);

        for (int value : arr) {
            sum += value;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // without using space
    // TC: O(n^2) SC : O(1)

    static int sum(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
