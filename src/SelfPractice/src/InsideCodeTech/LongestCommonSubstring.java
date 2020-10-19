package InsideCodeTech;

public class LongestCommonSubstring {

    public static void main(String[] args) {

//        String str1 = "opposite";
//        String str2 = "positione";

        String str1 = "inside";
        String str2 = "instead";

        System.out.println(LCSubStr(str1, str2, 0, 0, 0));
        System.out.println(LCSubstrDP(str1, str2));
    }

    // the idea is different then finding longest sub sequence
    // when ever char don't match make ur curr len 0
    // ans start searching with new indexes
    static int LCSubStr(String str1, String str2, int i, int j, int currLen) {
        // base case
        if (i >= str1.length() || j >= str2.length())
            return currLen;
        else if (str1.charAt(i) == str2.charAt(j)) {
            return Math.max(LCSubStr(str1, str2, i + 1, j + 1, currLen + 1),/*increase len*/
                    Math.max(LCSubStr(str1, str2, i + 1, j, 0),
                            LCSubStr(str1, str2, i, j + 1, 0)));
        } else {
            return Math.max(currLen,
                    Math.max(LCSubStr(str1, str2, i + 1, j, 0),
                            LCSubStr(str1, str2, i, j + 1, 0)));
        }
    }

    static int LCSubstrDP(String s1, String s2) {
        int x = s1.length();
        int y = s2.length();

        int[][] dp = new int[x + 1][y + 1];
        int maxLen = 0;
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
}
