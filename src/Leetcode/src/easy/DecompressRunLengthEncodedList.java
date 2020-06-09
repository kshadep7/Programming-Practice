package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLengthEncodedList {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4 };
		decompressRLElist(nums);
	}

	public static void decompressRLElist(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i += 2) {
			if (i < nums.length) {
				int freq = nums[i];

				for (int j = 0; j < freq; j++) {
					list.add(nums[i + 1]);
				}
			}
		}

		System.out.println(Arrays.toString(list.toArray()));
	}

}
