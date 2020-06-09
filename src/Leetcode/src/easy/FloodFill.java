package easy;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        floodFill(image, 0, 0, 2);
        System.out.println(Arrays.deepToString(image));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startingColor = image[sr][sc];
        if (startingColor != newColor)
            helper(image, sr, sc, newColor, startingColor);
        return image;
    }

    private static void helper(int[][] image, int i, int j, int newColor, int startingColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[i].length || image[i][j] == newColor) {
            return;
        }

        if (image[i][j] == startingColor) {
            image[i][j] = newColor;

            helper(image, i + 1, j, newColor, startingColor);
            helper(image, i - 1, j, newColor, startingColor);
            helper(image, i, j + 1, newColor, startingColor);
            helper(image, i, j - 1, newColor, startingColor);
        }
    }


}
