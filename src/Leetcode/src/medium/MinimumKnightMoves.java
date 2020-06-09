package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {

    public static void main(String[] args) {

        System.out.println(minKnightMoves(5, 5));
    }

    // using BFS
    public static int minKnightMoves(int x, int y) {

        final int[][] dir = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        int res = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                int[] currCell = que.remove();
                int currX = currCell[0];
                int currY = currCell[1];

                if (currX == x && currY == y)
                    return res;

                for (int[] point : dir) {
                    int newX = currX + point[0];
                    int newY = currY + point[1];

                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) {
                        que.add(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            res++;
        }
        return -1;
    }


}
