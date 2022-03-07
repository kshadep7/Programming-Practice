import java.util.Arrays;

public class ContinuousHouses {

	public static void main(String[] args) {
		int[] arr = {3, 1, 2};
		int[] arr1 = {2, 1, 3};
		System.out.println(Arrays.toString(sol(arr)));
		System.out.println(Arrays.toString(sol(arr1)));

	}

	// not working
	public static int[] sol(int[] queries) {
		int[] newArr = Arrays.copyOf(queries, queries.length);
		Arrays.sort(newArr);
		int max = newArr[newArr.length - 1];
		int[] res = new int[queries.length];
		int[] isBuilt = new int[max + 1];
		for (int i = 0; i < queries.length; i++) {
			if (queries[i] > 0 && queries[i] < isBuilt.length - 1) {
				isBuilt[queries[i]] = 1 + Math.max(isBuilt[queries[i] - 1], isBuilt[queries[i] + 1]);
				isBuilt[queries[i] - 1] = isBuilt[queries[i]];
				isBuilt[queries[i] + 1] = isBuilt[queries[i]];
			} else if (queries[i] == 0) {
				isBuilt[queries[i]] = 1 + Math.max(isBuilt[queries[i]], isBuilt[queries[i] + 1]);
				isBuilt[queries[i] + 1] = isBuilt[queries[i]];
			} else if (queries[i] == isBuilt.length - 1) {
				isBuilt[queries[i]] = 1 + Math.max(isBuilt[queries[i]], isBuilt[queries[i] - 1]);
				isBuilt[queries[i] - 1] = isBuilt[queries[i]];
			}

			res[i] = isBuilt[queries[i]];
		}

		return res;
	}

	public static int helper(int i, boolean isForward, int[] sum) {
		sum[0] += 1;
		if (isForward) {
			helper(i + 1, isForward, sum);
		} else {
			helper(i - 1, isForward, sum);
		}
		return sum[0];
	}

}
