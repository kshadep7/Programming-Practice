package InsideCodeTech;

import java.util.HashMap;
import java.util.Map;

/*Given two strings str1 and str2, create a function that returns the length of their longest common subsequence,
in other words, the subsequence that is present in both of them.

Example 1:
Input: str1 = "abdacbab", str2 = "acebfca"
Output: 4
Explanation: the length of the longest common subsequence of str1 and str2 is 4, this one for example: "abca"

Example 2:
Input: str1 = "cbebaff", str2 = "aeddbggf"
Output: 3
*/
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abdacbab"; // n
        String s2 = "acebfca"; // m

        String s3 = "cbebaff";
        String s4 = "aeddbggf";
//        System.out.println(findLongestCommSub(s3, s4));
        System.out.println(DP(s1, s2));
//        System.out.println(dpOptimized(s1, s2));
    }

    // without map: TC: 2 ^ (n+m)
    // SC: (n+m)
    // with  map: TC: nm SC: nm
    static int findLongestCommSub(String s1, String s2) {
        int len = helper(s1, s2, 0, 0, new HashMap<>());
        return len;
    }

    private static int helper(String s1, String s2, int i, int j, Map<String, Integer> memo) {
        String key = "" + i + j;
        if (i >= s1.length() || j >= s2.length())
            return 0;
        else if (memo.containsKey(key))
            return memo.get(key);
        else if (s1.charAt(i) == s2.charAt(j))
            // if chars match wee know subsequence has 1 char in common
            // so increament both pointers i and j of s1 and s2 respectively.
            return 1 + helper(s1, s2, i + 1, j + 1, memo);
        else {
            // first increament s1 index(i) and then check by increamenting s2 index(j)
            // and take max between both results.
            int res = Math.max(helper(s1, s2, i + 1, j, memo), helper(s1, s2, i, j + 1, memo));
            memo.put(key, res);
            return res;
        }
    }

    // TC: nm, SC: nm
    private static int DP(String s1, String s2) {
        int row = s1.length();
        int col = s2.length();
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        printMat(dp);
        return dp[row][col];
    }

    static void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
//                mat[i][j] = ++count;
                if (mat[i][j] < 10) {
                    System.out.print(mat[i][j] + "      ");
                } else if (mat[i][j] < 100) {
                    System.out.print(mat[i][j] + "     ");
                } else {
                    System.out.print(mat[i][j] + "   ");
                }
            }
            System.out.println("\n");
        }

    }

    // be optimzed more for space
    // observing dp matrix above -> to calculate next cell value we only need upper row values
    // so dont need the entire matrix at once
    // make dp arr on any string's len and make another arr named curr dp to be filled using dp arr
    // after one iteration, replace all values from curr dp to dp arr and make curr dp values 
    // to 0 to start another iteration
    // TC: nm, SC: m
    private static int dpOptimized(String s1, String s2) {
        int row = s1.length();
        int col = s2.length();

        int[] dp = new int[col + 1];
        int[] currDp = new int[col + 1];

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    currDp[j] = 1 + dp[j - 1];
                else
                    currDp[j] = Math.max(currDp[j - 1], dp[j]);
            }
            // putting all values from currDp to out actual dp
            for (int j = 1; j < col + 1; j++) {
                dp[j] = currDp[j];
                currDp[j] = 0;
            }
        }
        return dp[col];
    }
}
