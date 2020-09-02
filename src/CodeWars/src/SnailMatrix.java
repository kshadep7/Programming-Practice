import java.util.ArrayList;
import java.util.Arrays;

public class SnailMatrix {

    private static final int WALL = -1;

    public static void main(String[] args) {
        Test t;
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(Arrays.toString(snail1(mat)));
//        boolean[][] b = new boolean[2][2];
//        System.out.println(Arrays.deepToString(b));
    }

    static ArrayList<Integer> snail(int[][] mat) {
        if (mat == null || mat.length == 0)
            return null;

        ArrayList<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[mat.length][mat.length];
        helper(mat, 0, 0, res, visited);
        return res;
    }

    private static void helper(int[][] mat, int i, int j, ArrayList<Integer> res, boolean[][] visited) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat.length || res.size() == mat.length * mat.length)
            return;
        if (visited[i][j])
            return;

        visited[i][j] = true;
        res.add(mat[i][j]);

        helper(mat, i, j + 1, res, visited);
        helper(mat, i + 1, j, res, visited);
        helper(mat, i, j - 1, res, visited);
        helper(mat, i - 1, j, res, visited);
    }

    public static int[] snail1(int[][] array) {
        if (array[0].length <= 0) {
            return new int[0];
        }

        int n = array.length;
        int[] result = new int[n * n];
        int x = 0, y = 0;
        int xStep = 1, yStep = 0;

        for (int i = 0; i < result.length; ++i) {
            result[i] = array[y][x];
            array[y][x] = WALL;

            x += xStep;
            y += yStep;

            if (xStep != 0 && (x < 0 || x >= n || array[y][x] == WALL)) {
                x += -xStep;
                y += xStep;
                yStep = xStep;
                xStep = 0;
            } else if (yStep != 0 && (y < 0 || y >= n || array[y][x] == WALL)) {
                x += -yStep;
                y += -yStep;
                xStep = -yStep;
                yStep = 0;
            }
        }

        return result;
    }
}
