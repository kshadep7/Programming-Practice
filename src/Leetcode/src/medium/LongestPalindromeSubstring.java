package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {

        // longPalStr("aabba");
        System.out.println(longPalindromeSubstr("racecar"));
    }


    // faster algorithm using expand from middle method
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
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }
}
