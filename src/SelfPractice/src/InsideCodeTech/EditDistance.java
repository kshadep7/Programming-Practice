package InsideCodeTech;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

    public static void main(String[] args) {

        String word1 = "inside";
        String word2 = "index";

        String str1 = "eagles";
        String str2 = "algiers";

//        System.out.println(findMinOperations(word1, word2, 0, 0));

        Map<String, Integer> map = new HashMap<>();
//        System.out.println(findMinOperationsMemo(word1, word2, 0, 0, map));
//        System.out.println(map);

        System.out.println(findMinOperationsDP(word1, word2));
    }

    // calling resursive fun 3 times for every fun call
    // 1st call for removing a character
    // 2nd call for inserting a char
    // 3rd call for replacing a char
    // and we are traversing n and m chars (n+m)
    // so TC: 3 ^ (n+m)
    // SC : n+m -> max call stack space -> height of tree
    static int findMinOperations(String word1, String word2, int i, int j) {
        // base cases
        if (i == word1.length())
            return word2.length() - j;
        else if (j == word2.length())
            return word1.length() - i;
        else if (word1.charAt(i) == word2.charAt(j))
            return findMinOperations(word1, word2, i + 1, j + 1);
        else {
            return 1 +
                    Math.min(Math.min(
                            /*removal*/findMinOperations(word1, word2, i + 1, j), /*insert*/findMinOperations(word1, word2, i, j + 1)),
                            /*replace*/findMinOperations(word1, word2, i + 1, j + 1));
        }
    }

    // surely the recursive solution has repeated calls
    // we can use memoization or DP
    // using memoization
    // TC : n*m, SC: n*m
    static int findMinOperationsMemo(String word1, String word2, int i, int j, Map<String, Integer> memo) {
        String key = i + "" + j;
        //base cases
        if (memo.containsKey(key))
            return memo.get(key);
        else if (i == word1.length())
            return word2.length() - j;
        else if (j == word2.length())
            return word1.length() - i;
        else if (word1.charAt(i) == word2.charAt(j))
            return findMinOperationsMemo(word1, word2, i + 1, j + 1, memo);
        else {
            int min = 1 +
                    Math.min(Math.min(
                            /*removal*/findMinOperationsMemo(word1, word2, i + 1, j, memo), /*insert*/findMinOperations(word1, word2, i, j + 1)),
                            /*replace*/findMinOperationsMemo(word1, word2, i + 1, j + 1, memo));
            memo.put(key, min);
            return min;
        }
    }

    // using DP
    // the idea is to fill the 2d matrix first
    // TC: n*m, SC: n*m
    static int findMinOperationsDP(String word1, String word2) {
        int wordLen1 = word1.length();
        int wordLen2 = word2.length();

        int[][] dp = new int[wordLen1 + 1][wordLen2 + 1];
        dp[0][0] = 0;
        // fill 1st col
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        // fill 1st row
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[wordLen1][wordLen2];
    }
}
