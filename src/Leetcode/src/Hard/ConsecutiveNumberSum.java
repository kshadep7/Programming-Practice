package Hard;

public class ConsecutiveNumberSum {

    public static void main(String[] args) {
        System.out.println(consNumSum(15));
        System.out.println(consecutiveNumSum(15));
    }

    static int consNumSum(int val) {

        if (val == 0)
            return 1;
        final int MAX = Integer.MAX_VALUE;

        int count = 1;
        for (int i = 1; i < val - 1; i++) {
            int sum = i;
            int k = i + 1;
            while (sum <= val) {
                if (sum == val) {
                    count++;
                    break;
                }
                //handling overflow
//                if (sum < MAX / 10 || (sum == MAX / 10 &&))
                sum += k++;
            }
        }
        return count;
    }

    // math approach
    static int consecutiveNumSum(int N) {
        int ans = 0;

        for (int i = 2; (i * (i + 1) / 2) <= N; i++) {
            if ((N - (i * (i + 1) / 2)) % i == 0)
                ans++;
        }

        return ans + 1;
    }
}
