package medium;

import java.util.*;

public class MinimumCostToConnectAllCities {

    public static void main(String[] args) {

        int[][] connections = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}; // N = 3

        System.out.println(findMinCost1(3, connections));
    }

    static int findMinCost(int N, int[][] connections) {

        //using the connections make a graph
        int[][] graph = new int[N][N];
        makeGraph(connections, graph);

        int[] key = new int[N];
        boolean[] mstSet = new boolean[N];
        int[] parent = new int[N];

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < N - 1; i++) {

            int u = getMin(key, mstSet);

            mstSet[u] = true;

            for (int j = 0; j < N; j++) {
                if (graph[u][j] != 0 && mstSet[j] == false && graph[u][j] < key[j]) {
                    key[j] = graph[u][j];
                    parent[j] = u;
                }
            }
        }

        // calculate cost
        int cost = 0;
        for (int i = 0; i < N; i++) {
            cost += graph[parent[i]][i];
        }

        //check if all nodes are visited
        boolean areAllVisited = true;
        for (int i = 0; i < mstSet.length; i++) {
            if (mstSet[i] == false) {
                areAllVisited = false;
                break;
            }
        }
        return areAllVisited ? cost : -1;
    }

    private static int getMin(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < key.length; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void makeGraph(int[][] connections, int[][] graph) {
        for (int[] conn : connections) {
            int x = conn[0] - 1;
            int y = conn[1] - 1;
            int val = conn[2];

            graph[x][y] = val;
        }

        for (int[] row : graph)
            System.out.println(Arrays.toString(row));
    }


    //using min heap
    static int findMinCost1(int N, int[][] connections) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<Integer> visited = new HashSet<>();


        // creating a graph
        for (int[] conn : connections) {
            int src = conn[0], des = conn[1], val = conn[2];

            graph.computeIfAbsent(src, k -> new ArrayList<>());
            graph.computeIfAbsent(des, k -> new ArrayList<>());

            graph.get(src).add(new int[]{des, val});
            graph.get(des).add(new int[]{src, val});
        }

        // add first node to heap ->root node
        heap.add(new int[]{1, 1, 0});
        int cost = 0;
        // using BFS
        while (!heap.isEmpty()) {
            int[] temp = heap.poll();
            int src = temp[0], des = temp[1], val = temp[2];

            if (!visited.contains(des)) {
                cost += val;
                visited.add(des);
                for (int[] next : graph.get(des))
                    heap.add(new int[]{des, next[0], next[1]});
            }
        }

        return visited.size() == N ? cost : -1;
    }
}
