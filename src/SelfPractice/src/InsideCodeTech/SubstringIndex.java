package InsideCodeTech;

public class SubstringIndex {

    public static void main(String[] args) {

        String a = "akashrajendraadep", b = "rajendra";
        String a1 = "a", b1 = "a";
//        System.out.println(getIndex(a, b));
        System.out.println(getIndex1(a, b));
    }

    // brute force -> n2
    static int getIndex(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return i;
        }
        return -1;
    }

    // KMP algo for pattern matching
    // first finding LPS (longest prefix suffix) array using pattern string
    // then traverse through main string
    // 1. i and j are at same index
    // 2. if i and j are same -> increment i and j and increment len
    // 3. else if i ≠ j then using LPS array bring j back to lpsArr[len-1]
    // 4. else increment i
    // return i-j index -> where the pattern starts in main string

    // TC: n+m -> worse case n == m -> so 2n -> n
    // SC: m -> lps arr
    static int getIndex1(String main, String pattern) {
        int i = 0, j = 0;
        int n = main.length();
        int m = pattern.length();

        // base conditions
        if (m > n)
            return -1;
        if (m == n)
            return main.equals(pattern) ? 0 : -1;
        if (pattern.equals(""))
            return 0;
        // get lps arr
        int[] lps = getLpsArr(pattern);  // m
        while (i < n && j < m) {        // n
            if (main.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j > 0)
                j = lps[j - 1];
            else
                i++;
        }
        return j < m ? -1 : i - j;
    }

    static int[] getLpsArr(String pattern) {
        int len = 0;
        int m = pattern.length();
        int i = 1;
        int[] lpsArr = new int[m];
        lpsArr[0] = 0;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lpsArr[i] = len;
                i++;
            } else if (len > 0) {
                len = lpsArr[len - 1];
            } else {
                lpsArr[i] = 0;
                i++;
            }
        }
        return lpsArr;
    }
}
