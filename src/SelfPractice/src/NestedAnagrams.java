import java.util.Arrays;

public class NestedAnagrams {

	public static void main(String[] args) {

		System.out.println(nestedAnagram("below dusty", "study elbow"));
		System.out.println(nestedAnagram("aa bb", "ab ab"));
		System.out.println(nestedAnagram("meal for one", "for me alone"));
		System.out.println(nestedAnagram("bored cat", "act robed"));
	}

	/*
	("below dusty", "study elbow") --> True
	("aa bb", "ab ab") --> False
	("meal for one", "for me alone") --> False
	 */
	static boolean nestedAnagram(String s, String t) {

		if (s.length() != t.length())
			return false;

		// create a list of sorted words accoring to len of each word for bot
		// for every word check is charArray of each words is equal or not

		String[] arr1 = s.split(" ");
		String[] arr2 = t.split(" ");

		for (int i = 0; i < arr1.length; i++) {
			String s1 = arr1[i];
			char[] ch = s1.toCharArray();
			Arrays.sort(ch);
			arr1[i] = String.valueOf(ch);
		}

		for (int i = 0; i < arr2.length; i++) {
			String s1 = arr2[i];
			char[] ch = s1.toCharArray();
			Arrays.sort(ch);
			arr2[i] = String.valueOf(ch);
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		return Arrays.equals(arr1, arr2);
	}
}
