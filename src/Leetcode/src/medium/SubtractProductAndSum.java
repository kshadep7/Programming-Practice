package medium;

public class SubtractProductAndSum {

    public static void main(String[] args) {

        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        return product(n) - sum(n);
    }

    static int product(int n) {
        int pro = n % 10;
        n = n / 10;
        while (n != 0) {
            int a = n % 10;
            pro *= a;
            n /= 10;
        }
        return pro;
    }

    static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            int a = n % 10;
            sum += a;
            n /= 10;
        }
        return sum;
    }

}
