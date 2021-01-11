public class PrefixString {

    public static void main(String[] args) {

        String[] A = {"one", "two", "three"};
        String[] B = {"onetwo", "onethree"};

        System.out.println(prefixString(A, B));
    }

    static boolean prefixString(String[] A, String[] B) {

        if (A == null || A.length == 0)
            return false;

        for (String b : B) {        // N
            boolean[] dp = new boolean[b.length() + 1];
            dp[b.length()] = true;
            boolean res = helper(A, b, 0, dp);   // N
            if (!res)
                return false;
        }
        return true;
    }

    // reverse dp approach
    private static boolean helper(String[] A, String b, int start, boolean[] dp) {
        if (!dp[start]) {
            String sub = b.substring(start);
            for (String a : A) {
                if (sub.startsWith(a) && helper(A, b, start + a.length(), dp)) {
                    dp[start] = true;
                    return dp[start];
                }
            }
        }
        return dp[start];
    }
}
