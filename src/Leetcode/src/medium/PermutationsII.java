package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2};
        System.out.println(permuteUnique(arr));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(nums, used, curr, res);
        return res;
    }

    public static void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue;
            curr.add(nums[i]);
            used[i] = true;
            helper(nums, used, curr, res);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

}
