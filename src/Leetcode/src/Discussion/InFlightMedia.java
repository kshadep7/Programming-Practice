package Discussion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InFlightMedia {

	// https://leetcode.com/discuss/interview-question/1273052/Amazon-OA-or-SDE2
	public static void main(String[] args) {
		int flightDur = 90;
		List<Integer> movieDur = new ArrayList<>(Arrays.asList(1, 10, 25, 35, 60)); //	[2,3]
		List<Integer> movieDur1 = new ArrayList<>(Arrays.asList(1, 30, 25, 30, 35, 60));//	[1,3]
		List<Integer> movieDur2 = new ArrayList<>(Arrays.asList(1, 20, 25, 30, 60, 40));//	[1,5]
		System.out.println(twoMovies(flightDur, movieDur));
		System.out.println(twoMovies(flightDur, movieDur1));
		System.out.println(twoMovies(flightDur, movieDur2));
	}

	// 2 pointer approach
	// sort the list first maintaining the original indices
	static List<Integer> twoMovies(int flightDuration, List<Integer> movieDuration) {
		int targetDuration = flightDuration - 30;
		if (targetDuration < 0)
			return Arrays.asList(-1, -1);

		// to store the original indices
		int[][] arr = new int[movieDuration.size()][2];
		for (int i = 0; i < movieDuration.size(); i++) {	// N
			arr[i][0] = movieDuration.get(i);
			arr[i][1] = i;
		}

		// sort according to original values
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);	// NlogN
		System.out.println(Arrays.deepToString(arr));
		int lo = 0;
		int hi = movieDuration.size() - 1;

		while (lo < hi) {		// N
			int duration = arr[lo][0] + arr[hi][0];
			if ((targetDuration == duration) && arr[lo][1] <= lo)
				return Arrays.asList(arr[lo][1], arr[hi][1]);
			else if (duration > targetDuration)
				hi--;
			else
				lo++;
		}
		return Arrays.asList(-1, -1);
	}
}
