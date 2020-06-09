package medium;

import java.util.Arrays;

public class ProductSelfArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 2};
        System.out.println(Arrays.toString(product(arr)));
    }

    static int[] product(int[] arr) {
        int len = arr.length;

        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * arr[i - 1];
        }
        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r *= arr[i];
        }
        return ans;
    }
}
