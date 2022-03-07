package Discussion;

public class FarmLandWithWater {

	public static void main(String[] args) {

		char[][] mat = {
				{'E', 'E', 'E'},
				{'E', '#', 'W'},
				{'E', 'W', 'E'}};

		System.out.println(numberOfHours(mat));
	}

	public static int numberOfHours(char[][] mat) {
		int result = 0;
		boolean isAvailable = true;
		while (isAvailable) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					if (mat[i][j] == 'W') {
						//Look Bottom
						if ((i - 1) != -1 && mat[i - 1][j] == 'E') {
							mat[i - 1][j] = 'W';
						}//Look Left
						if ((j - 1) != -1 && mat[i][j - 1] == 'E') {
							mat[i][j - 1] = 'W';
						}//Look Top
						if ((i + 1) < mat.length && mat[i + 1][j] == 'E') {
							mat[i + 1][j] = 'W';
						}//Look Right
						if ((j + 1) < mat[i].length && mat[i][j + 1] == 'E') {
							mat[i][j + 1] = 'W';
						}
					}
				}
				for (char[] chars : mat) {
					for (char aChar : chars) {
						if (aChar == 'E') {
							isAvailable = true;
							break;
						} else {
							isAvailable = false;
						}
					}
					if (isAvailable) break;
				}
			}
			result++;
		}

		return result;
	}
}
