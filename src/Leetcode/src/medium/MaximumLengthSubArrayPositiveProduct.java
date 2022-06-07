package medium;

public class MaximumLengthSubArrayPositiveProduct {
	public static void main(String[] args) {

		int[] nums = {1, -2, -3, 4};
		int[] nums1 = {0, 1, -2, -3, -4};
		System.out.println(getMaxLength(nums));
		System.out.println(getMaxLength(nums1));
	}

	/*
	Idea:
	- counting the negative values
		- tracking positions of negative values
			- start negative and end negative
	points to consider:
	1. all values are positive for positive product
	2. even negative values
	3. if zeros present - sub arrays of non-zero element



	 */
	public static int getMaxLength(int[] nums) {
		int n = nums.length;
		int res = 0;
		for (int i = 0; i < n; ) {

			int start = i;
			while ((start < n) && (nums[start]) == 0) start++;
			int end = start;
			int negStart = -1, negEnd = -1;
			int negCount = 0;

			while ((end < n) && nums[end] != 0) {
				if (nums[end] < 0) {
					negCount++;
					if (negStart == -1) negStart = end;
					negEnd = end;
				}
				end++;
			}

			if (negCount % 2 == 0)
				res = Math.max(res, end - start);
			else {
				if (negStart != -1) res = Math.max(res, end - negStart - 1);
				if (negEnd != -1) res = Math.max(res, negEnd - start);
			}
			i = end + 1;
		}
		return res;
	}

}
