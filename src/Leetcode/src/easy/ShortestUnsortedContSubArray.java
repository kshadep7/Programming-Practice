package easy;

import java.util.Arrays;

public class ShortestUnsortedContSubArray {

    public static void main(String[] args) {

        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 2, 3, 3, 3};
        int[] arr3 = {1, 2, 3, 4};

//        System.out.println(findUnsortedArr(arr3));
        System.out.println(findUnsortedSubarray(arr3));


    }

    /*
     * The idea is pretty simple --> two pointers (one at start and one at end)
     * check from side of array if next num is smaller the previous one --> mark as start
     * similary, from right, traverse backwards and check if previous is bigger than current
     * once we have start and end indexes, return length of subarray
     * */
    // TODO: Doesnt work for already sorted array. FIX IT
    static int findUnsortedArr(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int start = 0, end = nums.length;
//        int i = 0, j = nums.length;
        while (start < end) {

            if (nums[start + 1] < nums[start] && nums[end - 1] > nums[end])
                break;

            if (nums[start + 1] >= nums[start])
                start++;

            if (nums[end - 1] <= nums[end])
                end--;

        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end + 1)));
        return end - start + 1;
    }

    // TC: O(n)
    // SC: O(1)
    public static int findUnsortedSubarray(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n - 1 - i]);
            if (A[i] < max) end = i;
            if (A[n - 1 - i] > min) beg = n - 1 - i;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(A, Math.max(beg, 0), Math.max(end + 1, 0))));
        return end - beg + 1;
    }
}
