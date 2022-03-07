package Hard;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(trap(arr));
		System.out.println(trapDP(arr));
		System.out.println(trap2Pointer(arr));
	}

	/*
	idea: TC - n2; SC - 1
	1. traverse thru arr
		1. check for left max height of building so far and same on the max on the right
		2. take the min of both and subtract the curr building height
		3. add it to ans
	 */
	public static int trap(int[] arr) {

		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			int left_max = Integer.MIN_VALUE;
			int right_max = Integer.MIN_VALUE;

			// check for left_max from curr element
			int j = i;
			while (j >= 0) {
				left_max = Math.max(left_max, arr[j--]);
			}
			// check for right_max from curr
			int k = i;
			while (k < arr.length) {
				right_max = Math.max(right_max, arr[k++]);
			}
			res += Math.min(left_max, right_max) - arr[i];
		}

		return res;
	}

	/*
	idea: TC - n,  SC - n
	dyanamic prog -> store max heights first according to the curr height index location
	and then iterate through original arr and check for max heigth left and right and calculate trap units
	and add to ans
	1. same idea as above but we can save max heights found so far so we can check just
		the curr height and previous or next height for max heights
	2. add to ans
	 */

	public static int trapDP(int[] heights) {

		int n = heights.length;
		int[] left_max = new int[n];
		int[] right_max = new int[n];

		// for left max height
		left_max[0] = heights[0];
		for (int i = 1; i < n; i++) {
			left_max[i] = Math.max(heights[i], left_max[i - 1]);
		}

		// for right max heights
		right_max[n - 1] = heights[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right_max[i] = Math.max(heights[i], right_max[i + 1]);
		}

		// calculate trap units and add to ans;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.min(left_max[i], right_max[i]) - heights[i];
		}

		return ans;
	}

	/*
	idea: TC: n, SC: 1
	two pointer
	1. left and right pointers
	2. for water to get trapped one building out of left and right has to equal or higher or lower
	than the other building
	3. so first check curr left height < right
		1. if yes check if curr hright is >= left_max then update left_max
		2 else add left_max - curr height to ans
		3. inc left
	4 else
		1. check if curr height >= right_max -> update right_max
		2. else add right_max - curr hright to ans
		3. dec right
	5 return ans
	 */

	public static int trap2Pointer(int[] height) {
		int left = 0;
		int right = height.length - 1;

		int left_max = 0, right_max = 0;
		int ans = 0;
		while (left < right) {

			if (height[left] < height[right]) {
				if (height[left] >= left_max)
					left_max = height[left];
				else
					ans += left_max - height[left];
				left++;
			} else {
				if (height[right] >= right_max)
					right_max = height[right];
				else
					ans += right_max - height[right];
				right--;
			}
		}
		return ans;
	}
}
