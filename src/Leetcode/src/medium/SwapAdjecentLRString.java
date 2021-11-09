package medium;

import java.util.Arrays;

public class SwapAdjecentLRString {

	//google

	public static void main(String[] args) {

		String start = "RXXLRXRXL";
		String end = "XRLXXRRLX";

		System.out.println(canTransform1("RXXL", "XRLX"));// true
		System.out.println(canTransform1("RXXL", "XLRX"));// false
		System.out.println(canTransform1("XLLR", "LXLX")); // false
		System.out.println(canTransform1(start, end)); //true
		System.out.println(canTransform1("XXXXXLXXXX", "LXXXXXXXXX")); //true

	}

	/*
	the idea is to swap and not swap containg these conditions
	0. check char arr == end str return true else everything else below
	1. If X recurse with increament index
	2. If R , check of X present in front of R
		2.1 return recurse(swap and incremented index) OR recurse(not swap and increment index)
	3. else if L, check for X before L
		3.1 repeat 2.1
	4. else recurse (increament index)
	* */

	// doesnt work !!
	public static boolean canTransform(String start, String end) {
		char[] startArr = start.toCharArray();
		char[] endArr = end.toCharArray();

		return helper(startArr, endArr, 0);
	}

	private static boolean helper(char[] startArr, char[] endArr, int i) {
		if (Arrays.equals(startArr, endArr))
			return true;
		else {
			if (i >= startArr.length)
				return false;
			if (i + 1 < startArr.length && startArr[i] == 'R') {
				if (startArr[i + 1] == 'X') {
					char[] noSwapArr = Arrays.copyOf(startArr, startArr.length);
					swap(startArr, i, i + 1);
					return helper(startArr, endArr, i + 1) || helper(noSwapArr, endArr, i + 1);
				}
			} else if (startArr[i] == 'L') {
				if (startArr[i - 1] == 'X') {
					char[] noSwapArr = Arrays.copyOf(startArr, startArr.length);
					swap(startArr, i, i - 1);
					return helper(startArr, endArr, i + 1) || helper(noSwapArr, endArr, i + 1);
				}
			} else if (startArr[i] == 'X')
				return helper(startArr, endArr, i + 1);

		}
		return helper(startArr, endArr, i + 1);
	}

	private static void swap(char[] startArr, int i, int j) {
		char tmp = startArr[i];
		startArr[i] = startArr[j];
		startArr[j] = tmp;
	}

	// the idea is to use 2 pointer
	// start and end indexes -> check for R chars one by one in both start and end strs
	// and assign index from start str as start index and from end str end index
	// first check if char of startidx and endidx are equal
	// then check If R then it can be moved to right i.e to end index to match in end str
	// i.e in this case startidx should be smaller than endidx
	// also check if L then it can be moved to left i.e to end index to match in end str
	// i.e in this case startidx should be greater than endidx

	// TC: n + n -> 2n -> n
	public static boolean canTransform1(String start, String end) {

		int startidx = 0;
		int endidx = 0;

		//traverse both strs
		while (startidx < start.length() || endidx < end.length()) {
			//find first non X char in start str
			while (startidx < start.length() && start.charAt(startidx) == 'X')
				startidx++;

			//find first non X char in end str
			while (endidx < end.length() && end.charAt(endidx) == 'X')
				endidx++;

			// check if one of idx reached at the end
			if (startidx == start.length() || endidx == end.length())
				return startidx == start.length() && endidx == end.length();

			//check if they are equal first
			if (start.charAt(startidx) != end.charAt(endidx))
				return false;

			// now check if R char then it can be moved to right
			// i.e startidx < endidx
			if (start.charAt(startidx) == 'R' && startidx > endidx)
				return false;

			// now check if L char then it can be moved to left
			// i.e startidx > endidx
			if (start.charAt(startidx) == 'L' && startidx < endidx)
				return false;

			startidx++;
			endidx++;
		}
		return true;

	}
}
