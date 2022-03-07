package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfMatchingSubsequences {

	public static void main(String[] args) {
		String s = "abcde";
		String[] words = {"a", "bb", "acd", "ace"};

		String s1 = "dsahjpjauf";
		String[] words1 = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};

		System.out.println(numMatchingSubseq(s, words));
		System.out.println(numMatchingSubseq(s1, words1));
	}

	/*
	Idea:
	1. saving all char of str as keys and corresponding words in word list starting with that key char
		in a list eg  a : [abc, ade, axe]
	2. Now traverse thru thr str
		2.1 if char found in map then get the list
		2.2 traverse thru list and remove first char from each word in list
		2.3 if word is empty inc res else check words next char is present in map or not
		2.4 if yes then that remaining word to respective key's list in the map.
	 */
	public static int numMatchingSubseq(String s, String[] words) {

		Map<Character, Queue<String>> map = new HashMap<>();

		// creating map with str's chars as keys and corresponsing lists as values
		for (char c : s.toCharArray())
			if (!map.containsKey(c))
				map.put(c, new LinkedList<String>());

		// adding words to list of respective keys
		for (String word : words) {
			char c = word.charAt(0);
			if (map.containsKey(c)) {
				map.get(c).offer(word);
			}
		}

		int res = 0;

		//traverse thru the str
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				Queue<String> q = map.get(c);
				int size = q.size();
				for (int j = 0; j < size; j++) {
					String word = q.poll();
//					assert word != null;
					// check if the remaining word is empty or not
					if (word.substring(1).length() == 0)
						res++;
					else {
						// add the remaining word to first char of the remaning word in the map
						// if that first char is present
						if (map.containsKey(word.charAt(1)))
							map.get(word.charAt(1)).offer(word.substring(1));
					}
				}
			}
		}

		return res;
	}


}
