package easy;

import java.util.HashSet;
import java.util.Set;

public class IsHappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(21));
    }

    static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }

        System.out.println(set);
        return n == 1;
    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int temp = n % 10;
            n = n / 10;
            totalSum += (temp * temp);
        }

        return totalSum;
    }
}
