package medium;

import java.util.Arrays;

public class AsteroidCollision {

	public static void main(String[] args) {

		int[] arr = {5, 10, -5};
		int[] arr1 = {8, -8};
		int[] arr2 = {10, 2, -5};
		int[] arr3 = {-2, -1, 1, 2};

		System.out.println(Arrays.toString(asteroidColl(arr)));
		System.out.println(Arrays.toString(asteroidColl(arr1)));
		System.out.println(Arrays.toString(asteroidColl(arr2)));
		System.out.println(Arrays.toString(asteroidColl(arr3)));

	}

	// idea is to increament and decreament top index
	// if num > 0, increment top and add num
	// if num < 0, then decreemnt top untill the curr num > top num
	// if num < 0 and top == -1, inc top and add num
	// if top num == curr num, dec top
	// TC: n
	public static int[] asteroidColl(int[] arr) {
		int[] ans = new int[arr.length];
		int top = -1;
		for (int a : arr) {        // n
			//if a is +ve then add to ans
			if (a > 0)
				ans[++top] = a;
			else {
				// if -ve then kill all smaller numbers
				while (top > -1 && ans[top] > 0 && ans[top] < -a)
					top--;
				// check if only -ve numbers are there from now onwards so no collisions
				// so direcly add them to arr
				if (top == -1 || ans[top] < 0)
					ans[++top] = a;
					// check if top num is equal to curr num then kill both nums
				else if (ans[top] == -a)
					top--;
			}
		}
		return Arrays.copyOf(ans, top + 1);
	}
}
