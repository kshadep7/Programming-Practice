package medium;

import java.util.Arrays;

public class WallsAndGates {

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };
        buildGrid(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    // using bfs
    static void buildGrid(int[][] rooms) {

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(i, j, 0, rooms);
                }
            }
        }
    }

    private static void dfs(int i, int j, int count, int[][] rooms) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < count)
            return;

        rooms[i][j] = count;

        dfs(i + 1, j, count + 1, rooms);
        dfs(i - 1, j, count + 1, rooms);
        dfs(i, j + 1, count + 1, rooms);
        dfs(i, j - 1, count + 1, rooms);
    }
}
