package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum2(arr));
    }

    // n3
    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> trips;
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {
                    if (i < len && j < len && k < len) {
                        if ((nums[i] + nums[j] + nums[k]) == 0) {
                            trips = new ArrayList<>();
                            trips.add(nums[i]);
                            trips.add(nums[j]);
                            trips.add(nums[k]);

                            res.add(trips);
                        }
                    }
                }
            }
        }
        return res;
    }

    // TC: n2
    // the idea is to use two sum technique on a sorted array -> check twoSum prob before
    // for lo and hi as our 2 nums, we will take third variable i as our 3rd number.
    static List<List<Integer>> threeSum2(int[] arr) {
        // sorting the arr
        Arrays.sort(arr);      // nlogn -> smaller than n2
        List<List<Integer>> res = new ArrayList<>();
        // iterate thru the arr i as 1st num and for other nums apply twoSum algo
        for (int i = 0; i < arr.length; i++) {      //N
            // check for first index
            // previous i and next are not same to avoid duplicates
            if (i == 0 || arr[i] != arr[i - 1])
                twoSum(i, arr, res);    // N
        }
        return res;
    }

    private static void twoSum(int i, int[] arr, List<List<Integer>> res) {
        int lo = i + 1, hi = arr.length - 1;
        while (lo < hi) {
            int sum = arr[i] + arr[lo] + arr[hi];
            if (sum < 0)
                lo++;
            else if (sum > 0)
                hi--;
            else {
                res.add(Arrays.asList(arr[i], arr[lo++], arr[hi--]));
                // check for duplicates
                // increament lo if next lo is same is as previous
                while (lo < hi && arr[lo] == arr[lo - 1])
                    lo++;
            }
        }
    }
}
