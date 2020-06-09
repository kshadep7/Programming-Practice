package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {

		partition("abcacdefghfe");
	}

	static void partition(String s) {

		List<Integer> list = new ArrayList<>();
		int[] lastSeenIndex = new int[26];
		for (int i = 0; i < s.length(); i++) {
			lastSeenIndex[s.charAt(i) - 'a'] = i;
		}
		System.out.println(Arrays.toString(lastSeenIndex));

		int divider = 0;
		int maxIndexValue = 0;
		for (int i = 0; i < s.length(); i++) {

			maxIndexValue = Math.max(maxIndexValue, lastSeenIndex[s.charAt(i) - 'a']);
			if (i == maxIndexValue) {
				list.add(i - divider + 1);
				divider = i + 1;
			}
		}
		System.out.println(list);
	}

}
