package medium;

import java.util.Arrays;
import java.util.Stack;

public class GraphBipartite {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//        System.out.println(isBipartite(arr));
    }

    static boolean isBipartite(int[][] graph) {

        int len = graph.length;
        int[] color = new int[len];
        Arrays.fill(color, -1);

        for (int start = 0; start < len; start++) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(start);
                color[start] = 0;

                while (!stack.isEmpty()) {
                    Integer node = stack.pop();
                    for (int neig : graph[node]) {
                        if (color[neig] == -1) {
                            stack.push(neig);
                            color[neig] = color[node] ^ 1;
                        } else if (color[neig] == color[node])
                            return false;
                    }
                }
            }
        }
        return true;
    }

}
