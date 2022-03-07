import java.util.*;

public class OnCallRoatationNonOverlappingPeriods {

	public static void main(String[] args) {
		Map<String, int[]> rotations = new HashMap<>();
		rotations.put("Abby", new int[]{1, 10});
		rotations.put("Ben", new int[]{5, 7});
		rotations.put("Carla", new int[]{6, 12});
		rotations.put("David", new int[]{15, 17});

//		System.out.println(getOnCall(rotations));
	}

	public static Map<String, Set<String>> getOnCall(Map<String, int[]> rotations) {
		List<Integer> times = new ArrayList<>();
		Map<String, Set<String>> res = new HashMap<>();


		// get all values in the list
		for (Map.Entry<String, int[]> entry : rotations.entrySet()) {
			times.add(entry.getValue()[0]);
			times.add(entry.getValue()[1]);
		}
		// sort the list
		Collections.sort(times);    // nlogn
		// 1 5 6 7 10 12 15 17
		for (int i = 0; i < times.size() - 1; i++) {    // n
			int[] interval = new int[]{times.get(i), times.get(i + 1)};
			Set<String> names = new HashSet<>();
			for (Map.Entry<String, int[]> entry : rotations.entrySet()) { // m
				if (isOverlap(interval, entry.getValue())) {
					names.add(entry.getKey());
				}
			}
			if (!names.isEmpty())
				res.put(interval[0] + "-" + interval[1], names);
		}
		return res;
	}

	private static boolean isOverlap(int[] before, int[] after) {
		return (before[1] > after[0] && before[0] < after[1]);
	}

}
