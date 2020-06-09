package ArraysAndStrings;

import java.util.HashSet;

public class ZeroMatrix {

    public static void main(String[] args) {

    }

    // Zero Matrix: Write an algorithm such that if an element in an MxN matrix is
    // 0, its entire row and column are set to 0.
    public static void zeroMatrix(int m, int n) {
        // TODO: Pending to resolve -> how to get value from a HashSet. if not
        // Using HashSet ->
        // Getting all the coordinates of zeros of a matrix in a HashSets
        // (maintaining two separate HashSets for row and col)
        // iterate through those two has sets and loop it to zero all
        // the corresponding coordinates.
        int[][] mat = new int[m][n];
        boolean[][] matBool = new boolean[m][n];
        int count = 0;
        System.out.println("Original Matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ++count;
                if (mat[i][j] == 7 || mat[i][j] == 8 || mat[i][j] == 3 || mat[i][j] == 25)
                    mat[i][j] = 0;
                if (mat[i][j] < 10) {
                    System.out.print(mat[i][j] + "      ");
                } else if (mat[i][j] < 100) {
                    System.out.print(mat[i][j] + "     ");
                } else {
                    System.out.print(mat[i][j] + "   ");
                }
            }
            System.out.println("\n");
        }

        System.out.println(mat.length + "x" + mat[0].length);

        HashSet<Integer> setRow = new HashSet<>();
        HashSet<Integer> setCol = new HashSet<>();
        int zeros = 0, row, col;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    // zeros++;
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }
        System.out.println("Rows: " + setRow.toString());
        System.out.println("Cols: " + setCol.toString());

        for (Integer integer : setRow) {
            for (int i = 0; i < mat[0].length; i++) {
                mat[integer][i] = 0;
            }
        }

        for (Integer integer : setCol) {
            for (int i = 0; i < mat.length; i++) {
                mat[i][integer] = 0;
            }
        }

        System.out.println("Zero Matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < 10) {
                    System.out.print(mat[i][j] + "      ");
                } else if (mat[i][j] < 100) {
                    System.out.print(mat[i][j] + "     ");
                } else {
                    System.out.print(mat[i][j] + "   ");
                }
            }
            System.out.println("\n");
        }

    }

}
