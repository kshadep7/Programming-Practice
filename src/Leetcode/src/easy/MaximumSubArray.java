package easy;

public class MaximumSubArray {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArr(arr));

    }

    static int maxSubArr(int[] arr) {
        int currSum = arr[0], maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
