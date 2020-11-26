package InsideCodeTech;

import java.util.HashMap;

public class Knapsack01 {

    public static void main(String[] args) {

        int[] values = {20, 15, 25, 10};
        int[] weights = {6, 5, 10, 3};

        System.out.println(findMaxValue(values, weights, 15));
        System.out.println(findMaxValueMemo(values, weights, 15));
    }

    // iterative apporach
    // TC: n2
    // SC: 1
    static int findMaxValue(int[] values, int[] weights, int maxWeight) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            int currvalue = values[i];
            int currWeight = maxWeight - weights[i];
            for (int j = 1; j < values.length; j++) {
                if (currWeight - weights[j] >= 0) {
                    currvalue += values[j];
                    currWeight -= weights[j];
                    maxValue = Math.max(maxValue, currvalue);
                }
            }
        }
        return maxValue;
    }

    // recursive approach
    // using memoiz
    // TC: how many possible keys -> n * maxWeight
    // SC: n * maxWeight keys in map
    static int findMaxValueMemo(int[] values, int[] weights, int maxWeight) {
        return helper(values, weights, 0, maxWeight, new HashMap<>());
    }

    private static int helper(int[] values, int[] weights, int i, int maxWeight,
                              HashMap<String, Integer> memo) {
        String key = "" + i + maxWeight;
        if (memo.containsKey(key))
            return memo.get(key);
        else if (i >= values.length)
            return 0;
        else if (weights[i] > maxWeight) {
            int out = helper(values, weights, i + 1, maxWeight, memo);
            memo.put(key, out);
            return out;
        } else {
            int out = Math.max(
                    values[i] + helper(values, weights, i + 1, maxWeight - weights[i], memo),
                    helper(values, weights, i + 1, maxWeight, memo));
            memo.put(key, out);
            return out;
        }
    }
}
