package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {

	public static void main(String[] args) {
		int[][] arr = {{-5, 4}, {-6, -5}, {4, 6}};
		int[][] out = kClosest(arr, 2);
		int[][] out1 = kClosestMaxHeap(arr, 2);

		System.out.println(Arrays.deepToString(out));
		System.out.println(Arrays.deepToString(out1));
	}

	public static int[][] kClosest(int[][] points, int K) {

		if (points.length == K)
			return points;

		int[][] out = new int[K][2];
		int[] distances = new int[points.length];
		//finding euc distance and storing it
		for (int i = 0; i < points.length; i++) {
			distances[i] = findDistance(points[i]);
		}
//        System.out.println(Arrays.toString(distances));
		Arrays.sort(distances);
		int dist = distances[K - 1];
		int i = 0;
		for (int j = 0; j < points.length; j++) {
			if (findDistance(points[j]) <= dist && i < K) {
				out[i] = points[j];
				i++;
			}
		}

		return out;
	}

	private static int findDistance(int[] arr) {
		return (int) (arr[0] * arr[0] + arr[1] * arr[1]);
	}


	//using Max heap
	// NlogK
	// if K == N then its (N log N)
	public static int[][] kClosestMaxHeap(int[][] arr, int K) {
		// creating maxHeap
		// so that all the K min points should remain in the heap
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> findDistance(b) - findDistance(a));

		for (int[] point : arr) {
			heap.add(point);
			if (heap.size() > K)
				heap.remove();
		}
		int[][] out = new int[K][2];
		int i = 0;
		while (!heap.isEmpty()) {
			out[i++] = heap.remove();
		}
		return out;
	}
}
