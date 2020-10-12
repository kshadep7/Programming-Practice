package InsideCodeTech;

public class WaysToClimbStairs {

    public static void main(String[] args) {

        int[] steps = {1, 2}; // n = 5
        int[] steps1 = {2, 3, 4}; // n = 7
        int[] steps2 = {2, 4, 5, 8}; // n = 10
        System.out.println(noOfWays(7, steps1));
        System.out.println(noOfWaysDP(10, steps2));
    }

    static int noOfWays(int n, int[] steps) {
        int res = helper(n, steps, 0, 0);
        return res;
    }

    // recursion
    // TC : (len of arr)^n -> huge
    // SC: n - > call stack
    static int helper(int n, int[] steps, int move, int count) {
        if (move > n)
            return count;
        if (move == n)
            count++;
        for (int step : steps) {
            count = helper(n, steps, move + step, count);
        }
        return count;
    }

    // repeatative calls using recursive approach
    // TC: n*m
    // SC: n -> dp arr
    static int noOfWaysDP(int n, int[] steps) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int step : steps) {
                if (i - step >= 0) {
                    dp[i] += dp[i - step];
                }
            }
        }
        return dp[n];
    }
}
