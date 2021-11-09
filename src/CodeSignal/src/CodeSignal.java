import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeSignal {

	public static void main(String[] args) {

	}

	static String[] concatEdgeLetters(String[] arr) {

		List<String> res = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			String curr = arr[i];
			String next = "";
			if (i == arr.length - 1)
				next = arr[0];
			else
				next = arr[i + 1];
			res.add("" + curr.charAt(0) + next.charAt(next.length() - 1));
		}
		String[] ans = new String[res.size()];

		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	public static int sumOfFirsts(int arr[]) {
		//declare variable
		int i, sum = 0;
//loop until value is returned
		while (true) {
			//find first number which is not equal to 0
			for (i = 0; i < arr.length; ++i) {
				if (arr[i] != 0)
					break;
			}
			//if reached end then return su/
			if (i == arr.length)
				return sum;

			int x = arr[i];
//go to right elements of i
			for (int j = i; j < arr.length; ++j) {
				if (arr[j] < x)
					break;
				else
					arr[j] = arr[j] - x;
			}
			//step 3
			sum = sum + x;
		}
	}

	static int[] handleCollectionRequests(int[] nums, int[][] operations) {

		List<Integer> ls = new ArrayList<>();
		for (int i : nums)
			ls.add(i);
		Collections.sort(ls);
		List<Integer> res = new ArrayList<>();
		int min = ls.get(0);
		for (int[] op : operations) {
			if (op.length == 1) {
				// find min and add to res
				res.add(min);
			} else {
				if (op[0] == 1) {
					//append
					ls.add(op[1]);
					Collections.sort(ls);
					min = ls.get(0);
				} else if (op[0] == 0) {
					//add value to all i's
					for (int i = 0; i < ls.size(); i++) {
						ls.set(i, ls.get(i) + op[1]);
					}
				}
			}
		}

		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}
}

