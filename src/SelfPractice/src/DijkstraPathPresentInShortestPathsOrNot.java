import java.util.*;

public class DijkstraPathPresentInShortestPathsOrNot {

	public static void main(String[] args) {

		Graph graph = new Graph();

		int g_nodes = 5;
		int[] g_from = new int[]{1, 2, 3, 4, 5, 1, 5};
		int[] g_to = new int[]{2, 3, 4, 5, 1, 3, 3};
		int[] g_weight = new int[]{1, 1, 1, 1, 3, 2, 1};

		for (int i = 0; i < g_nodes; i++) {
			graph.addNode(new Node(i + 1));
		}


		for (int i = 0; i < g_from.length; i++) {
			graph.addEdge(
					graph.nodes.get(g_from[i] - 1)
					, graph.nodes.get(g_to[i] - 1)
					, g_weight[i]);
		}

		System.out.print("Nodes: ");
		for (Node node : graph.nodes) {

			// System.out.println(node.adjNodes);
			System.out.print(node.val + "[ ");

			for (Node neigh : node.adjNodes.keySet()) {
				System.out.print(neigh.val + " ");
			}
			System.out.print("] ");
		}

		System.out.println("");


		System.out.println("Edges: " + graph.edges);

		findShortestDistance(graph, graph.nodes.get(0));


		List<String> results = new ArrayList<>();

		for (int i = 0; i < graph.edges.size(); i++) {
			results.add("NO");
		}

		dfs(graph, 5, results);

		for (int i = 0; i < graph.edges.size(); i++) {
			System.out.print(results.get(i));
			System.out.print(" ");
		}

	}

	static class Graph {
		List<Node> nodes;
		List<String> edges;


		public Graph() {
			nodes = new ArrayList<>();
			edges = new ArrayList<>();
		}

		void addNode(Node node) {
			nodes.add(node);
		}

		void addEdge(Node sourceNode, Node endNode, int weight) {
			sourceNode.addAdjNode(endNode, weight);
			endNode.addAdjNode(sourceNode, weight);
			edges.add(sourceNode.val + "-" + endNode.val);
		}

	}

	static class Node {
		Integer val;
		Map<Node, Integer> adjNodes;
		Integer shortestPathFromSource;
		Set<Node> parentsInShortestPath;
		Boolean visited;

		public Node(Integer v) {
			val = v;
			adjNodes = new HashMap<>();
			shortestPathFromSource = Integer.MAX_VALUE;
			visited = Boolean.FALSE;
			parentsInShortestPath = new HashSet<>();
		}

		void addAdjNode(Node adjNode, int weight) {
			adjNodes.put(adjNode, weight);
		}

	}

	private static void dfs(Graph graph, Integer n, List<String> results) {
		if (n == 1) {
			return;
		}

		Iterator<Node> itr = graph.nodes.get(n - 1).parentsInShortestPath.iterator();
		while (itr.hasNext()) {
			Node parent = itr.next();
			int index = graph.edges.indexOf(parent.val + "-" + n);
			if (index == -1) {
				index = graph.edges.indexOf(n + "-" + parent.val);
			}
			if (index != -1) {
				results.set(index, "TRUE");
				dfs(graph, parent.val, results);
			}
		}

		return;
	}

	private static void findShortestDistance(Graph graph, Node sourceNode) {

		PriorityQueue<Node> minHeap = new PriorityQueue<>((x, y) -> x.shortestPathFromSource.compareTo(y.shortestPathFromSource));

		sourceNode.shortestPathFromSource = 0;
		minHeap.add(sourceNode);

		while (!minHeap.isEmpty()) {
			Node minNode = minHeap.poll();
			minNode.visited = Boolean.TRUE;

			Map<Node, Integer> adjNodes = minNode.adjNodes;

			for (Node adjNode : adjNodes.keySet()) {
				if (!adjNode.visited) {
					if (minNode.shortestPathFromSource + adjNodes.get(adjNode) <= adjNode.shortestPathFromSource) {

						adjNode.shortestPathFromSource = minNode.shortestPathFromSource + adjNodes.get(adjNode);

						adjNode.parentsInShortestPath.add(minNode);

						minHeap.add(adjNode);

					} else {
						adjNode.parentsInShortestPath.remove(minNode);
					}
				}
			}

		}
	}


}
