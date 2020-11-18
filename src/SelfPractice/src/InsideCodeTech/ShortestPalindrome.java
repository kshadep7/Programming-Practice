package InsideCodeTech;

public class ShortestPalindrome {

    public static void main(String[] args) {

        String str = "acbcabcbb";
        System.out.println(findShortPalin(str));
        System.out.println(findShortPalin2(str));
    }

    // brute force
    // idea is to find longest palindrome first
    // then append remaing sub str to str in reverse to main str
    // TC: n2
    static String findShortPalin(String str) {
        int maxLen = 0;
        //  acbcabcbb
        for (int i = 0; i < str.length(); i++) {        // N
            if (isPalindrome(str.substring(0, i + 1))) {        // N
                maxLen = i;
            }
        }
        String rem = str.substring(maxLen + 1);
        return new StringBuilder(rem).reverse().toString() + str;
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {        // N
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // to find longest palindrome prefix as we did in the first apporach
    // we can use KMP algo -> using longest suffix prefix method -> N
    // TC: N
    // SC: N -> lps array
    static String findShortPalin2(String str) {
        String newStr = str + new StringBuilder(str).reverse().toString();  // N
        // now get LPS array
//        System.out.println(Arrays.toString(newStr.toCharArray()));
        int[] lps = getLPS(newStr);     // N
        int lenOfPalin = lps[newStr.length() - 1];
        String rem = str.substring(lenOfPalin);

        return new StringBuilder(rem).reverse().toString() + str;
    }

    // for getting longest palindrome suffix
    private static int[] getLPS(String newStr) {
        int[] lps = new int[newStr.length()];
        lps[0] = 0;
        int i = 1;
        int len = 0;

        while (i < newStr.length()) {       // N
            if (newStr.charAt(i) == newStr.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
//        System.out.println(Arrays.toString(lps));
        return lps;
    }
}