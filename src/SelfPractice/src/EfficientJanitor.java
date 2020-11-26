import java.util.Arrays;

public class EfficientJanitor {

    public static void main(String[] args) {
        double[] arr = {1.01, 1.991, 1.32, 1.4};
    }

    static int efficientJan(double[] arr, double limit) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (arr[i] + arr[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }
}
