import java.util.Hashtable;
import java.util.Map;

public class ArrayCommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Question: Given two sorted arrays, find the number of elements in common. The
		// arrays are the same length
		// and each has all distinct elements.

		int[] arr1 = { 13, 27, 35, 40, 49, 55, 59 };
		int[] arr2 = { 17, 35, 39, 40, 55, 58, 60 };

		findCommon1(arr1, arr2);
	}

	public static void findCommon(int[] arr1, int[] arr2) {

		Map<Integer, Integer> map = new Hashtable<>();
		for (int i = 0; i < arr2.length; i++) {
			map.put(arr2[i], arr2[i]);
		}

		System.out.println(map.toString());
		for (int i = 0; i < arr1.length; i++) {
			if (map.containsKey(arr1[i])) {
				System.out.print(arr1[i] + " ");
			}
		}

	}

	public static void findCommon1(int[] arr1, int[] arr2) {
		int i = 0, j = 0;

		// for (int i = 0; i < arr1.length; i++) {

		while (i < arr1.length) {
			if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i]);
				i++;
				// break;
			} else {
				j++;
			}
		}
		// }
	}
}
