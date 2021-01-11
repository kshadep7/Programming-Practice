package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {

        System.out.println(combinations(5, 3));
    }

    static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(n, k, 1, res, curr);
        return res;
    }

    private static void helper(int n, int k, int i, List<List<Integer>> res, List<Integer> curr) {
        if (k == 0)
            res.add(new ArrayList<>(curr));
        else {
            for (int j = i; j <= n - k + 1; j++) {
                curr.add(j);
                helper(n, k - 1, j + 1, res, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
