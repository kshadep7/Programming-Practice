package Algorithms;

import java.util.Arrays;

public class PrimsMST {

    static int minSum = 0;

    public static void main(String[] args) {
        /*
            2         3
        (0)-----(1)-----(2)
         |     / \      /
        6|  8/   5\    /7
         |  /      \  /
        (3)--------(4)
               9
        */

        int[][] graph = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        int[][] graph1 = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 0, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
//        primsMST(graph);
        System.out.println("\n");
        primsMST(graph1);

    }

    // TC: n2
    // SC: mstSet -> n
    // can bee reduced -> using min heap for finding min valued node
    static void primsMST(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V];
//        List<Integer> res = new ArrayList<>();  // to store the result nodes in order
        int[] key = new int[V];     // to update weights of respective node (index -> vertex)
        boolean[] mstSet = new boolean[V];  // visited set

        Arrays.fill(key, Integer.MAX_VALUE); // making weight of every vertex as max value
        key[0] = 0; // starting node's weight is 0
        parent[0] = -1;

        for (int i = 0; i < V - 1; i++) {       // n
            int u = getMin(key, mstSet);    // n  --> get the min valued vertices from all unvisited nodes

            mstSet[u] = true;
//            res.add(u);

            for (int j = 0; j < V; j++) {       // n
                // check for the adjecent nodes and their weights
                // update the key arr with lowest weight and update parent arr
                if (graph[u][j] != 0 && mstSet[j] == false && graph[u][j] < key[j]) {
                    key[j] = graph[u][j];
                    parent[j] = u;
                }
            }
        }

        int cost = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
            cost += graph[parent[i]][i];
        }
        System.out.println("min cost: " + cost);
//        System.out.println(res);
//        System.out.println(minSum);
    }

    private static int getMin(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < key.length; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        }
        minSum += min;
        return min_index;
    }
}
