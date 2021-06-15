package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsetsll {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2};
        System.out.println(subsetsWithoutDups(arr));

    }

    // TC: close to N * 2^N -> worst case
    static List<List<Integer>> subsetsWithoutDups(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);  // NlogN
        helper(curr, res, 0, nums);
        return res;
    }

    private static void helper(List<Integer> curr, List<List<Integer>> res, int index, int[] nums) {
        res.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])    // check for previous same element (sorted array)
                continue;
            curr.add(nums[i]);
            helper(curr, res, i + 1, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
