import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TernaryTreePaths {

	public static void main(String[] args) {
		String[] inputs = {"1 2 5 x x x x x 3 x x x 4 x x x", "1 2 3 x x x 4 x x x 7 x x x 5 x x x 6 x x x"};
		for (int i = 0; i < inputs.length-1; i++) {
			Node root = Node.buildTree(Arrays.stream(inputs[i].split(" ")).iterator());
			System.out.println("Ternary tree paths : " + Arrays.toString(TernaryTreePaths.ternaryTreePaths(root)));
		}
	}

	public static String[] ternaryTreePaths(Node root) {
		if (root == null) return null;
		ArrayList<String> res = new ArrayList<>();
		dfs(root, new ArrayList<>(), res);
		return res.toArray(new String[res.size()]);
	}

	// dfs helper function
	private static void dfs(Node root, ArrayList<String> path, ArrayList<String> res) {
		// exit condition, reached leaf node, append paths to results
		if (root.children[0] == null && root.children[1] == null && root.children[2] == null) {
			path.add(Integer.toString(root.val));
			res.add(String.join("->", path));
			return;
		}

		// dfs on each non-null child
		for (Node child : root.children) {
			if (child != null) {
				ArrayList<String> pathCopy = new ArrayList<>(path);
				pathCopy.add(Integer.toString(root.val));
				dfs(child, pathCopy, res);
			}
		}
	}

}

class Node {
	int val;
	Node[] children;

	public Node(int val, Node[] children) {
		this.val = val;
		this.children = children;
	}

	public static Node buildTree(Iterator<String> nodes) {
		String nxt = nodes.next();
		if (nxt.equals("x")) return null;
		Node node = new Node(Integer.parseInt(nxt), new Node[3]);
		for (int i = 0; i < 3; i++) {
			node.children[i] = buildTree(nodes);
		}
		return node;
	}
}

