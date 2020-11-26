import java.util.Set;
import java.util.TreeSet;

public class AllSubStringPalindromes {

    public static void main(String[] args) {

        String s = "abaaa";
        System.out.println(allSubPalindromes(s));
    }

    // findning all distinct substring palindromes
    // idea is to build a dp matrix get get all substring palindromes
    // TC: n2, SC: n2
    static Set<String> allSubPalindromes(String s) {

        Set<String> ans = new TreeSet<>();
        int n = s.length();
        int[][] dp = new int[n][n];

        // for length of 1 plaindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            ans.add("" + s.charAt(i));
        }

        // for length of 2 palindrome
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                ans.add(s.substring(i, i + 2));
            }
        }
        // fill rest of cells diagonally for substr len > 2 using previous cells values
        // 1. check for ith char == jth char and
        // 2. between sub string is palindrome or not
        int start = -1, end = s.length();
        int j = 0;
        // this loop for length of substr -> starting from len 3 (i.e index 2)
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                //calculate j
                j = i + k;
                //check the 2 conditions
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    ans.add(s.substring(i, j + 1));
                }
            }
        }
        return ans;
    }
}
