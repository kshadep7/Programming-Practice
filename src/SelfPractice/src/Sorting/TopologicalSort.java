package Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Directed Acyclic Graph
class DAG {
    int v;
    List<List<Integer>> adjList;

    public DAG(int v) {
        this.v = v;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }
}

public class TopologicalSort {

    public static void main(String[] args) {
        DAG g = new DAG(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(g.adjList);

        System.out.println(topoSort(g));

    }

    static List<Integer> topoSort(DAG graph) {
        Stack<Integer> stack = new Stack<>();
        int v = graph.v;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                dfs(i, graph, visited, stack);
        }

        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private static void dfs(int i, DAG graph, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        List<Integer> neigh = graph.adjList.get(i);
        for (int j = 0; j < neigh.size(); j++) {
            if (!visited[j])
                dfs(neigh.get(j), graph, visited, stack);
        }
        stack.push(i);
    }
}
