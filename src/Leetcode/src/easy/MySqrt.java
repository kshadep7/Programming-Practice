package easy;

public class MySqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(81));
    }

    // 1 2 3 4 5 6 7 8

    static int sqrt(int n) {
        if (n < 2) return n;

        int lo = 1;
        int hi = n;

        while (lo <= hi) {

            int mid = (lo + hi)/ 2;
            if (mid <= n / mid) lo = mid + 1;
            else hi = mid - 1;
        }
        return hi;
    }
}
