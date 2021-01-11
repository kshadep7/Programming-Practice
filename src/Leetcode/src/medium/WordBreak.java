package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>(Arrays.asList("code", "leet"));
        List<String> list2 = new ArrayList<>(Arrays.asList("apple", "pen"));
        List<String> list3 = new ArrayList<>(Arrays.asList("aaaa", "aaa"));
        String s1 = "leetcode";
        String s2 = "applepenapple";
        String s3 = "aaaaaaa";

//        System.out.println(Break(s, list));
        System.out.println(wordBreak1(s2, list2));
    }

    // 0 ms solution:
    // dp with recursion
    public static boolean wordBreak1(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length() + 1];
        dp[s.length()] = true;
        return innerWordBreak(s, wordDict, 0, dp);
    }
    // reverse dp approach
    private static boolean innerWordBreak(String s, List<String> wordDict, int start, Boolean[] dp) {
        if (dp[start] == null) {
            String sub = s.substring(start);
            for (String word : wordDict) {
                if (sub.startsWith(word) && innerWordBreak(s, wordDict, start + word.length(), dp)) {
                    dp[start] = true;
                    return dp[start];
                }
            }
            dp[start] = false;
        }
        return dp[start];
    }

    // won't work for s = "aaaaaaa"
    public static boolean wordBreak(String s, List<String> words) {
        if (words == null || words.size() == 0)
            return false;
        int i = 0;
        String curr = "";
        while (i < s.length()) {
            curr += s.charAt(i);
            if (words.contains(curr)) {
                curr = "";
            }
            i++;
        }
        return curr == "";
    }


    // have to use DP
    static boolean Break(String s, List<String> words) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && words.contains(sub)) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }


}
