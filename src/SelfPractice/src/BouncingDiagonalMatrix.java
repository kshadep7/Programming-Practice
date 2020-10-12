import java.util.Arrays;
import java.util.Comparator;

public class BouncingDiagonalMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return 1;
                else if (o1[0] == o2[0])
                    return 0;
                else
                    return -1;
            }
        });
        System.out.println(Arrays.deepToString(arr));
    }

    static int[] bounce(int[][] matrix) {
        int col = matrix.length;
        int[] arr = new int[col];
        int[][] countArr = new int[col][2];

        for (int i = 0; i < col; i++) {
            countArr[i][0] = matrix[i][0];
            countArr[i][1] = helper(matrix, i, 0, 0, false);

        }

/*
        Arrays.sort(countArr, (a, b) -> {
            if (a[1] < b[1])
                return 1;
            else if (a[1] == b[1]) {
                if (a[0] < b[0])
                    return 1;
            } else {
                return 0;
            }
            return 0;
        });
*/
        int x = 0;
        for (int[] i : countArr) {
            arr[x++] = i[0];
        }
        return arr;
    }

    private static int helper(int[][] matrix, int i, int j, int sum, boolean isBounced) {
        if (i < 0 || j >= matrix[0].length) {
            return 0;
        }
        if (isBounced) {
            sum = matrix[i][j] + helper(matrix, i + 1, j + 1, sum, true);
        }
        sum = matrix[i][j] + helper(matrix, i - 1, j + 1, sum, false);
        return sum;
    }


}
