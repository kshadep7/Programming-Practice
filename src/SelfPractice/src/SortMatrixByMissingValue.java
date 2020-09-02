import java.util.Arrays;

public class SortMatrixByMissingValue {

    public static void main(String[] args) {

        String[][] matrix = {
                {"14", "3", "10", "4", "16", "10", "?", "2", "?", "9", "15", "11"},
                {"16", "7", "8", "2", "1", "4", "8", "3", "3", "16", "7", "13"},
                {"?", "9", "6", "5", "14", "12", "7", "6", "2", "10", "4", "14"},
                {"15", "1", "13", "12", "9", "15", "5", "13", "1", "8", "12", "6"}
        };

        sort(matrix);
    }

    static String[][] sort(String[][] matrix) {

        String[][] ans = new String[4][matrix[0].length];
        int[][] missingValues = new int[matrix[0].length / 4][2];

        int totalSum = (16 * 17) / 2;
        int ptr = 0;

        for (int j = 0; j < matrix[0].length; j += 4) {
            int sum = 0;
            int x = -1, index = -1;
            for (int i = 0; i < 4; i++) {

                if (matrix[i][j].equals("?")) {
                    x = i;
                    index = j;
                    sum += Integer.parseInt(matrix[i][j + 1])
                            + Integer.parseInt(matrix[i][j + 2])
                            + Integer.parseInt(matrix[i][j + 3]);
                    continue;
                }
                if (matrix[i][j + 1].equals("?")) {
                    x = i;
                    index = j + 1;
                    sum += Integer.parseInt(matrix[i][j])
                            + Integer.parseInt(matrix[i][j + 2])
                            + Integer.parseInt(matrix[i][j + 3]);
                    continue;
                }
                if (matrix[i][j + 2].equals("?")) {
                    x = i;
                    index = j + 2;
                    sum += Integer.parseInt(matrix[i][j])
                            + Integer.parseInt(matrix[i][j + 1])
                            + Integer.parseInt(matrix[i][j + 3]);
                    continue;
                }
                if (matrix[i][j + 3].equals("?")) {
                    x = i;
                    index = j + 3;
                    sum += Integer.parseInt(matrix[i][j])
                            + Integer.parseInt(matrix[i][j + 1])
                            + Integer.parseInt(matrix[i][j + 2]);
                    continue;
                }

                sum += Integer.parseInt(matrix[i][j])
                        + Integer.parseInt(matrix[i][j + 1])
                        + Integer.parseInt(matrix[i][j + 2])
                        + Integer.parseInt(matrix[i][j + 3]);

            }

            int missing = totalSum - sum;
            matrix[x][index] = "" + missing + "*";
            missingValues[ptr++] = new int[]{missing, index / 4}; // (missing value, square position)
        }
        System.out.println(Arrays.deepToString(matrix));

        // sort the missing values array by 0th index
        Arrays.sort(missingValues, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(missingValues));

        int col = 0;
        for (int i = 0; i < missingValues.length; i++) {
            int pos = missingValues[i][1];
            for (int j = 4 * pos; j < 4 * (pos + 1); j++) {
                for (int k = 0; k < 4; k++) {
                    ans[k][col] = matrix[k][j];
                }
                col++;
            }
        }
        System.out.println("\n");
        System.out.println(Arrays.deepToString(ans));
        return null;
    }
}
