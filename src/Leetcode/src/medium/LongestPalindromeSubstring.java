package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {

        // longPalStr("aabba");
//        System.out.println(longPalindromeSubstr("racecar"));
        System.out.println(longestPalSubStringDP("aaaabbaa"));
    }


    // faster algorithm using expand from middle method
    //TC: n2, SC: 1
    static String longPalindromeSubstr(String s) {
        if (s == null || s.length() <= 0)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // for odd len palindrome substring
            // eg -> rac(e)car
            //			 i
            int len1 = expandFromCentre(s, i, i);
            // for even len palindrome substring
            // eg -> aa(b  b)aa
            //   		i i+1
            int len2 = expandFromCentre(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    static int expandFromCentre(String s, int left, int right) {
        if (s == null || left > right)
            return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // why -1 at the end?
        // coz the loop goes one time after finding the last same char
        // eg -> "acbcd" expanding from b at index 2 it finds c on left index (1) and right index (3)
        // 		  01234  so your loop has not ended yet so left becomes 0 and right is 4
        // thats y (4 - 0 - 1 = 3) -> final length of palindrome "cdc"
    }

    // using dp
    // the idea is to check if start and end char of a substring are equal and middle part
    // is also a palindrome --> for this we need to fill the matrix first for 2 chars
    // and then check for rest of the substrings
    // TC: n2, SC: n2
    static String longestPalSubStringDP(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        //first fill the diagnal with 1 as a single char is always a palindrom
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // fill the second diagonal as well by checking next element of single char as same
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = 1;
        }
//        printMat(dp);

        // filling the remaining cells diagonally and keeping a track of start and end pointer indexes
        // to get max length of palndrome subsrting
        int len = 0, j = 0;
        int start = -1, end = s.length();
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                j = i + k;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    if (len < j - i + 1) {
                        len = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    // a a b b a a
    // 0 1 2 3 4 5
    // n! --> finding all the substring and then checking if one of them is a palindrome of max length
    public static void longPalStr(String s) {

        // getting list of substrings
        List<String> ls = getSubstrings(s);
        System.out.println(ls);
        int maxLen = Integer.MIN_VALUE;
        String res = "";
        for (String str : ls) {
            // check if palindrome
            if (isPalindrome(str)) {
                // keep max length palindrome
                if (str.length() > maxLen) {
                    maxLen = str.length();
                    res = str;
                }
            }
        }
        System.out.println(!res.equals("") ? res : "empty");

    }

    static List<String> getSubstrings(String s) {
        Set<String> set = new TreeSet<>();
        int len = 0;
        while (len < s.length()) {
            String str = "";
            for (int i = len; i < s.length(); i++) {
                str += Character.toString(s.charAt(i));
                set.add(str);
            }
            len++;
        }

        return new ArrayList<>(set);
    }

    static boolean isPalindrome(String s) {
        String rev = reverse(s);
        return s.equals(rev);
    }

    static String reverse(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
/*
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        return builder.toString();
*/
    }
}
