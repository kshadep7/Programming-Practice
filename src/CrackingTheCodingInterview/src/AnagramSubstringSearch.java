import java.util.Arrays;

public class AnagramSubstringSearch {
	static final int MAX = 26;

	// This function returns true if contents
	// of arr1[] and arr2[] are same, otherwise
	// false.

	// This function search for all permutations
	// of pat[] in txt[]
	static void search(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		// countP[]: Store count of all
		// characters of pattern
		// countTW[]: Store count of current
		// window of text
		char[] countP = new char[MAX];
		char[] countTW = new char[MAX];
		
		for (int i = 0; i < M; i++) {
			(countP[pat.charAt(i)-'a'])++;
			(countTW[txt.charAt(i)-'a'])++;
		}
		
		System.out.println("Starting Window:" + Arrays.toString(countTW));

		// Traverse through remaining characters
		// of pattern
		for (int i = M; i < N; i++) {
			// Compare counts of current window
			// of text with counts of pattern[]
			if (compare(countP, countTW))
				System.out.println("Found at Index " + (i - M));

			// Add current character to current
			// window
			(countTW[txt.charAt(i)-'a'])++;

			// Remove the first character of previous
			// window
			countTW[txt.charAt(i - M)-'a']--;
		}

		// Check for the last window in text
		if (compare(countP, countTW))
			System.out.println("Found at Index " + (N - M));
	}
	
	static boolean compare(char arr1[], char arr2[]) {
//		for (int i = 0; i < MAX; i++)
//			if (arr1[i] != arr2[i])
//				return false;
		return Arrays.equals(arr1, arr2);
//		return true;
	}


	public static void main(String[] args) {

		String txt = "abcabc";
		String pat = "abc";
		search(pat, txt);

	}

}
