package medium;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestandSmallestValueThreeMoves {

	public static void main(String[] args) {

		int[] arr = {1,5,6,13,14,15,16,17};
		System.out.println(minDifference(arr));
	}

	/*
	A = [1,5,6,13,14,15,16,17]
n = 8

Case 1: kill 3 biggest elements

All three biggest elements can be replaced with 14
[1,5,6,13,14,15,16,17] -> [1,5,6,13,14,14,14,14] == can be written as A[n-4] - A[0] == (14-1 = 13)

Case 2: kill 2 biggest elements + 1 smallest elements

[1,5,6,13,14,15,16,17] -> [5,5,6,13,14,15,15,15] == can be written as A[n-3] - A[1] == (15-5 = 10)

Case 3: kill 1 biggest elements + 2 smallest elements

[1,5,6,13,14,15,16,17] -> [6,6,6,13,14,15,16,16] == can be written as A[n-2] - A[2] == (16-6 = 10)

Case 4: kill 3 smallest elements

[1,5,6,13,14,15,16,17] -> [13,13,13,13,14,15,16,17] == can be written as A[n-1] - A[3] == (17-13 = 4)

Answer is minimum of all these cases!
	 */

	// TC: nlogn -> coz of sorting
	public static int minDifference(int[] nums) {

		Arrays.sort(nums);
		int n = nums.length;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			res = Math.min(res, (nums[n - 4 + i] - nums[i]));
		}

		return res;
	}
}