package medium;

public class MaximumPointsfromCards {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,1};
		int k = 3;

		System.out.println(maxScore(arr, k));
	}

	public static int maxScore(int[] cardPoints, int k) {

		int n = cardPoints.length - 1;
		int lSum = 0, rSum = 0;

		for (int i = 0; i < k; i++) {
			lSum += cardPoints[i];
		}

		int max = lSum;
		for (int i = 0; i < k; i++) {
			rSum += cardPoints[n - i];
			lSum -= cardPoints[k - 1 - i];
			max = Math.max(max, lSum + rSum);
		}
		return max;
	}
}
