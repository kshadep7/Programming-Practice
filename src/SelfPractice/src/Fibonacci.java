public class Fibonacci {

    public static void main(String[] args) {
        // System.out.println(fib(6));
//		System.out.println(fib(6, new int[7]));
        System.out.println(fibBotUp(6));
    }

    static int fib(int n) {
        if (n <= 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    // using DP --> Top Down
    static int fib(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1)
            return 1;
        else {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);

            return memo[n];
        }
    }

    // using DP --> Bottom up
    static int fibBotUp(int n) {

        if (n <= 1)
            return 1;

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        memo[n] = fibBotUp(n - 1) + fibBotUp(n - 2);

        return memo[n];
    }
}
