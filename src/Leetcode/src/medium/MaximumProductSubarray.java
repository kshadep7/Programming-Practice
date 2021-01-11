package medium;

public class MaximumProductSubarray {

    public static void main(String[] args) {

        int[] arr = {2, 3, -2, 4};
        int[] arr2 = {-3, 0, 1, -2};
        int[] arr1 = {0, 2};
        int[] arr3 = {2, -1, 1, 1};
        System.out.println(maxProduct(arr3));
        System.out.println(maxProduct1(arr3));
    }

    // n2
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length < 2)
            return nums[0];

        int res = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (i == j)
                    max = nums[i];
                else
                    max *= nums[j];
                res = Math.max(max, res);
            }
        }
        return res;
    }

    // modified kadane's algorithm
    static int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length < 2)
            return nums[0];

        int currMax = nums[0];
        int currMin = nums[0];

        int res = currMax;

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * currMax, nums[i] * currMin));

            currMax = tempMax;
            res = Math.max(res, currMax);
        }
        return res;
    }
}
