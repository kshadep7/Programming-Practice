package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        System.out.println(findAllCombinations(arr, target));

    }

    static List<List<Integer>> findAllCombinations(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;

        List<Integer> currCombination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, currCombination, res, 0);

        return res;

    }

    private static void helper(int[] candidates, int target,
                               List<Integer> currCombination, List<List<Integer>> res, int startIdx) {
        if (target == 0) {
            res.add(new ArrayList<>(currCombination));
            return;
        }

        for (int j = startIdx; j < candidates.length; j++) {
            if (candidates[j] > target)
                break;

            currCombination.add(candidates[j]);
            helper(candidates, target - candidates[j], currCombination, res, j);
            currCombination.remove(currCombination.size() - 1);
        }
    }
}
