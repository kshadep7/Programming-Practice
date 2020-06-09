import java.util.LinkedList;

public class Graph {

    int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    LinkedList<Integer>[] adj;
    int time = 0;
    static final int NIL = -1;

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);    //Add v to w's list
    }

}
