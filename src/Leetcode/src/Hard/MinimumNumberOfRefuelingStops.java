package Hard;

import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {

	public static void main(String[] args) {
		int target = 100;
		int startFuel = 10;
		int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};

		System.out.println(mminStops(target, startFuel, stations));
	}

	// greedy apprach
	public static int mminStops(int target, int startFuel, int[][] stations) {
		if (startFuel >= target)
			return 0;

		int i = 0;
		int n = stations.length;
		int minStops = 0;
		int maxDistance = startFuel;

		// to keep fuel of stations
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		while (maxDistance < target) {
			// keep on adding untill we can reach curr maxDistance i.e we can visit all those stations
			while (i < n && stations[i][0] <= maxDistance) {
				maxHeap.offer(stations[i][1]);
				i++;
			}

			// if no stations can be visited then cannot reach target
			if (maxHeap.isEmpty())
				return -1;

			// add max fuel from heap
			maxDistance += maxHeap.poll();
			// inc stops
			minStops++;
		}

		return minStops;
	}
}
