package medium;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "2326";
        System.out.println(numWays(s));
    }

    static int numWays(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {

            int currDigit = Integer.parseInt(s.substring(i - 1, i));
            int currAndPrevDigit = Integer.parseInt(s.substring(i - 2, i));
            if (currDigit >= 1 && currDigit <= 9)
                dp[i] += dp[i - 1];
            if (currAndPrevDigit >= 10 && currAndPrevDigit <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }
}
