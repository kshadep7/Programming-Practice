package Discussion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsInContainer {
	/*
	Given a string s consisting of items as "*" and closed compartments as an open
	and close "|", an array of starting indices startIndices, and an array of
	ending indices endIndices, determine the number of items in closed
	compartments within the substring between the two indices, inclusive.

	An item is represented as an asterisk *
	A compartment is represented as a pair of pipes | that may or may not have
	items between them.

	Example:
	s = '|**|*|*'
	startIndices = [1,1]
	endIndices = [5,6]

	The String has a total 2 closed compartments, one with 2 items and one with
	1 item. For the first par of indices, (1,5), the substring is '|**|*'.
	There are 2 items in a compartment.
	For the second pair of indices, (1,6), the substring is '|**|*|' and
	there 2+1=3 items in compartments.
	Both of the answers are returned in an array. [2,3].
	 */

	public static void main(String[] args) {
		String str = "|**|*|*";
		List<Integer> startIdx = new ArrayList<>(Arrays.asList(1, 1));
		List<Integer> endIdx = new ArrayList<>(Arrays.asList(5, 6));
		System.out.println(numberOfItems(str, startIdx, endIdx));
	}

	static List<Integer> numberOfItems(String str, List<Integer> startIndices, List<Integer> endIndices) {
		// idea is to record number of stars first
		// count no of stars before '|'
		//then loop through the the start indices and look for
		// start '|'  and end '|' and subtract no of starts

		//count no of stars before each '|'
		int[] memory = new int[str.length()];
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '|')
				memory[i] = count;
			else
				count++;
		}

		List<Integer> res = new ArrayList<>();
		//loop through the each indices
		// 2 pointer approach to find '|' on both ends
		for (int i = 0; i < startIndices.size(); i++) {
			int start = startIndices.get(i) - 1;
			int end = endIndices.get(i) - 1;

			while (start < end && str.charAt(start) != '|')
				start++;
			while (start < end && str.charAt(end) != '|')
				end--;

			res.add(memory[end] - memory[start]);
		}

		return res;
	}
}
