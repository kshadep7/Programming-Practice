package ArraysAndStrings;

public class MatrixRotation {

    public static void main(String[] args) {

    }

    public static void matrixRotation(int n) {
        int count = 0;
        int[][] mat = new int[n][n];
        // int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };

        System.out.println("Original Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ++count;
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
        for (int layer = 0; layer < n / 2; layer++) {
            // layer loop for making our way inside
            for (int i = layer; i < n - 1 - layer; i++) {
                // temp = top
                int temp = mat[layer][i];
                // top = right
                mat[layer][i] = mat[i][n - 1 - layer];
                // right = bottom
                mat[i][n - 1 - layer] = mat[n - 1 - layer][n - 1 - i];
                // bottom = left
                mat[n - 1 - layer][n - 1 - i] = mat[n - 1 - i][layer];
                // left = temp
                mat[n - 1 - i][layer] = temp;
            }
        }
        System.out.println("\n");
        System.out.println("Rotated Matrix: ");
        for (int i = 0; i < n; i++) {
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
