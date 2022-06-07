package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class IsSubsequence {

	public static void main(String[] args) {

		String s = "abc", t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}

	public static boolean isSubsequence(String s, String t) {

		// precomputation, build the hashmap out of the target string
		HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
		for (int i = 0; i < t.length(); ++i) {
			if (letterIndicesTable.containsKey(t.charAt(i)))
				letterIndicesTable.get(t.charAt(i)).add(i);
			else {
				ArrayList<Integer> indices = new ArrayList<Integer>();
				indices.add(i);
				letterIndicesTable.put(t.charAt(i), indices);
			}
		}

		Integer currMatchIndex = -1;
		for (char letter : s.toCharArray()) {
			if (!letterIndicesTable.containsKey(letter))
				return false; // no match, early exist

			boolean isMatched = false;
			// greedy match with linear search

			List<Integer> idxList = letterIndicesTable.get(letter);
			Integer matchIndex = Collections.binarySearch(idxList, currMatchIndex);
			if (matchIndex != idxList.size())
				currMatchIndex = idxList.get(matchIndex);
			else
				return false;
/*
			for (Integer matchIndex : letterIndicesTable.get(letter)) {
				if (currMatchIndex < matchIndex) {
					currMatchIndex = matchIndex;
					isMatched = true;
					break;
				}
			}
*/

//			if (!isMatched)
//				return false;
		}

		// consume all characters in the source string
		return true;
	}

}
