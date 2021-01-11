package medium;

public class ConstructKPalindromicStrings {

    public static void main(String[] args) {

        String s = "annabelle";     // k = 2
        String s1 = "leetcode";     // k = 3
        System.out.println(canConstruct(s1, 3));
    }

    static boolean canConstruct(String s, int k) {
        int[] count = new int[26];
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            odd += ++count[s.charAt(i) - 'a'] % 2 == 0 ? -1 : 1;
        }

        return odd <= k && k <= s.length();
    }
}
