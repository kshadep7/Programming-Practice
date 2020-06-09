package medium;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(version(12, 20));
    }

    // 12,14,16, 17, 18, 19, 20

    static int version(int good, int bad) {

        int lo = good;
        int hi = bad;

        while (lo < hi - 1) {

            int mid = lo + (hi - lo) / 2;
            if (testVersion(mid))
                lo = mid;
            else
                hi = mid;
        }
        return lo + 1;
    }

    static boolean testVersion(int x) {
        switch (x) {
            case 17:
            case 18:
            case 19:
            case 20:
                return false;
            default:
                return true;
        }
    }
}
