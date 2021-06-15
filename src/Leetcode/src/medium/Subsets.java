package medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // no duplicates present
//        System.out.println(subsets(arr));
        System.out.println(subsets1(arr));
    }

    // Not readable enough
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        res.add(new ArrayList<>());
        helper(curr, res, 0, nums);
        return res;
    }

    private static void helper(List<Integer> curr, List<List<Integer>> res, int index, int[] nums) {
        if (index >= nums.length)
            return;
        else {
            curr.add(nums[index]);
            helper(curr, res, index + 1, nums);
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            helper(curr, res, index + 1, nums);
        }
    }
}
