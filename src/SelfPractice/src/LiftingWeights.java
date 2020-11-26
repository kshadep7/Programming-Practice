import java.util.HashMap;

public class LiftingWeights {

    public static void main(String[] args) {

        int[] weights = {1, 3, 5};
        System.out.println(maxWeight(weights, 7));
    }

    // similar to knapsack 01
    static int maxWeight(int[] weigths, int maxCapacity) {
        return helper(weigths, maxCapacity, 0, new HashMap<>());
    }

    private static int helper(int[] weigths, int maxCapacity, int i, HashMap<String, Integer> memo) {
        String key = i + " " + maxCapacity;
        if (memo.containsKey(key))
            return memo.get(key);
        else if (i >= weigths.length)
            return 0;
        else if (weigths[i] > maxCapacity) {
            int out = helper(weigths, maxCapacity, i + 1, memo);
            memo.put(key, out);
            return out;
        } else {
            int out = Math.max(
                    weigths[i] + helper(weigths, maxCapacity - weigths[i], i + 1, memo),
                    helper(weigths, maxCapacity, i + 1, memo));
            memo.put(key, out);
            return out;
        }
    }
}
