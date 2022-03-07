package Hard;

public class MedianOf2SortedArrays {

	public static void main(String[] args) {

		int[] arr1 = {1, 3, 8, 9, 15};
		int[] arr2 = {7, 11, 19, 18, 21, 25};

		System.out.println(sol(arr1, arr2));
	}

	// idea - merge arrs and find middle index even or odd -> TC - m+n
	/*
	idea for log(min(m, n))
	the median divides the array into two equal halves
	x -> x1 x2 x3 x4
	y -> y1 y2 y3 y4 y5 y6

	when merged the res arr becomes
	x1 x2 x3 x4 y1 y2 y3 y4 y5 y6
	so median is (y1+y2)/2 if len is odd and if even just mid of arr
	so instead of megrging arrs we can find such partition or elements from both arrs and return median

	so partitionX + partitiony = (len(arr1) + len(arr2) + 1) / 2
	the +1 of rhs is coz it handle the even odd case correctly
	eg. Notice that if a number num is even, then num/2 = (num + 1)/2, for example 4/2 = (4 + 1)/2 = 2. So (m + n)/2 is equal to (m + n + 1)/2

	so egde cases can be there can be 0 elements on the left side from arr x or y or 0 elements on right
	from x or y.. in that case consider -inf on left as thats the smallest element on left and +inf on
	the right as thats the largest number on the right in a sorted arr

	all in all we have to satisfy these consitions to find such partition
	1. len(left_part) (elements from x and y) <= len(right_part) (elements from x and y)
	2. if maxLeftX <= minRightY && maxLeftY <= minRightX

	if above consitions satisfy then we know we have found the partion
	then just calculate median
		if arr1 + arr2 is even return (max(maxLeftX, maxLeftY), min(minRightX, minRightY))/2
		if odd just return max(maxLeftX, maxLeftY)

	if not then check how to update hi and low
		if maxLeftX > minRightY then reduce partition x i.e reduce hi by 1 when hi is ur partitionX
		else increase partitionX

	1. first randomly partition smallest arr (i.e start by middle partion)
	2. binary search number on smaller arr
		2.1 if conditions meet and return median given even or odd
	 */

	public static double sol(int[] arr1, int[] arr2) {
		// find small arr first and then idea
		if (arr1.length > arr2.length)
			return sol(arr2, arr1);

		// arr1 is always small len
		int x = arr1.length;
		int y = arr2.length;

		int lo = 0;
		int hi = x;

		// binary search
		while (lo <= hi) {
			// parX + parY = (x+y+1)/2
			int partitionX = (lo + hi) / 2; // part in middle of arr1
			int partitionY = ((x + y + 1) / 2) - partitionX; // rest of it

			// check of egde cases where left or right part can be empty
			// if parX = 0 then maxleftX will be -inf --> that idea
			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
			int minRightX = partitionX == x ? Integer.MAX_VALUE : arr1[partitionX];

			// same for arr2
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY - 1];
			int minRightY = partitionY == y ? Integer.MAX_VALUE : arr2[partitionY];

			// check condition 1
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

				// if even
				if ((x + y) % 2 == 0)
					return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2);
				else // if odd we have median on left side
					return ((double) Math.max(maxLeftX, maxLeftY));
			} else if (maxLeftX > minRightY)
				hi = partitionX - 1;
			else
				lo = partitionX + 1;
		}

		// if invalid inputs -> arrs are not sorted
		throw new IllegalArgumentException();
	}
}
