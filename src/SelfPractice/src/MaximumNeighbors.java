import java.util.HashMap;
import java.util.HashSet;

public class MaximumNeighbors {

	public static void main(String[] args) {

	}

	/*
	A A A B C
	A B B D E
	A C D D A

	ans = 3 -> b has max neighbors A C D
	 */

	//TODO: solve it
	public char sol(char[][] matrix) {
		HashMap<Character, Integer> visited = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (visited.containsKey(matrix[i][j])) {
					continue;
				} else {
					int count = helper(matrix[i][j], i, j, new HashSet<String>());
					visited.put(matrix[i][j], count);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		char resChar = ' ';
//		for ()
		return resChar;
	}

	private int helper(char matrix, int i, int j, HashSet<String> strings) {
		return 0;
	}


}
