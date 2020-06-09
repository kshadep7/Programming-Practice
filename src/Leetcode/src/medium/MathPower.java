package medium;

public class MathPower {
    static double ans = 1.00;

    public static void main(String[] args) {
        System.out.println(myPow(4, 4));
    }

    static double myPow(double x, int n) {
//        System.out.println(x);
        if (n == 0) return ans;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        if (n % 2 == 0) ans = myPow(x * x, n / 2);
        else ans = x * myPow(x * x, n / 2);

        return ans;
    }
}
