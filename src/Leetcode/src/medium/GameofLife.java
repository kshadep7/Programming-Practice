package medium;

import java.util.Arrays;

public class GameofLife {

    public static void main(String[] args) {

        int[][] arr = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};

        int[][] arr1 = {
                {1, 1},
                {1, 0}};

        for (int[] x : getNextState(arr))
            System.out.println(Arrays.toString(x));

    }

    static int[][] getNextState(int[][] currentState) {
        int row = currentState.length;
        int col = currentState[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int[][] nextState = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int neighboursLive = getNeighbours(currentState, i, j, directions);

                if (currentState[i][j] == 1) {
                    if (neighboursLive < 2) {
                        nextState[i][j] = 0;
                    } else if (neighboursLive == 2 || neighboursLive == 3) {
                        nextState[i][j] = 1;
                    } else
                        nextState[i][j] = 0;
                } else if (currentState[i][j] == 0) {
                    if (neighboursLive == 3)
                        nextState[i][j] = 1;
                }
            }
        }
        return nextState;
    }

    private static int getNeighbours(int[][] currentState, int i, int j, int[][] dirs) {

        int count = 0;
        for (int[] dir : dirs) {
            int newX = i + dir[0], newY = j + dir[1];
            if (newX < 0 || newX >= currentState.length || newY < 0 || newY >= currentState[0].length)
                continue;
            if (currentState[newX][newY] == 1)
                count++;
        }
        return count;
    }
}
