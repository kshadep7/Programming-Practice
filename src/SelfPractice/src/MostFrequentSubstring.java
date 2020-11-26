import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubstring {

    static final int mod = 1000000007;

    public static void main(String[] args) {

        String s = "ababab";
        System.out.println(mostFreqSubstring(s, 2, 3, 4));
    }

    static int mostFreqSubstring(String s, int minLen, int maxLen, int maxUniq) {
        int n = s.length();

        int[][] freq = new int[n][26];

        for (int i = 0; i < n; i++) {
            freq[i][s.charAt(i) - 'a']++;
        }
        printMat(freq);

        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i <= n - minLen; i++) {
            int j = i + minLen - 1;

            int coutChar = countUniqueChars(i, j, n, freq);
            if (coutChar > maxUniq)
                continue;

            int ans = computeRollingHash(s, i, j);
            map.put(ans, map.getOrDefault(ans, 0) + 1);

            maxCount = Math.max(maxCount, map.get(ans));
        }

        return maxCount;
    }

    static int computeRollingHash(String s, int l, int r) {
        s = s.substring(l, r - l + 1);

        int n = s.length();


        int p = 31;
        int p_power = 1;

        int hashValue = 0;

        for (int i = 0; i < n; i++) {
            int adder = ((s.charAt(i) - 'a' + 1) * p_power) % mod;
            hashValue = (hashValue + adder) % mod;

            p_power = (p_power * p) % mod;
        }
        return hashValue;
    }

    static int countUniqueChars(int i, int j, int n, int[][] freq) {
        int count = 0;

        for (int k = 0; k < 26; k++) {
            int charCount = freq[j][k] - ((i == 0) ? 0 : freq[i - 1][k]);

            if (charCount == 1)
                count++;
        }
        return count;
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

}
