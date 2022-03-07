import java.util.HashSet;
import java.util.Set;

public class BuildObstacleNumberLine {

	public static void main(String[] args) {

		int[][] arr = {
				{1, 2},
				{1, 5},
				{1, 3},
				{2, 3, 2},
				{2, 3, 3},
				{2, 1, 1},
				{2, 1, 2},
				{2, 0, 3}};
		System.out.println(sol(arr));

	}

	public static String sol(int[][] operations) {

		StringBuilder sb = new StringBuilder();

		Set<Integer> obstacles = new HashSet<>();
		for (int[] arr : operations) {
			if (arr.length == 2) {
				obstacles.add(arr[1]);
			}
		}
//		System.out.println(map);
		a:
		for (int[] arr : operations) {
			if (arr.length == 3) {
				int start = arr[1];
				int size = arr[1] + arr[2];
				b:
				for (int i = start; i < size; i++) {
					if (obstacles.contains(i) && i > start) {
						sb.append("0");
						continue a;
					}
				}
				sb.append("1");
			}
		}
		return sb.toString();
	}

}
