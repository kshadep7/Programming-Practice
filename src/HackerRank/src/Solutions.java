public class Solutions {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		System.out.println(numOfSubarrays(arr, 3, 3));
	}

	static public int numOfSubarrays(int[] arr, int size, int k) {
		int sum = 0;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i < size) {
				sum += arr[i];
				if (i == size - 1 && sum == k * size) {
					result++;
				}
			} else {
				sum = sum + arr[i] - arr[i - size];
				if (sum == k * size) {
					result++;
				}
			}

		}

		return result;
	}
}
