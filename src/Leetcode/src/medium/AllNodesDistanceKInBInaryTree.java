package medium;

import java.util.*;

public class AllNodesDistanceKInBInaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		TreeNode target = root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		System.out.println(allNodes(root, target, 2));
	}

	/*
	Idea: focus on the target node
	go level by level from target nodes to iots children and parent
	it should look like a graph to you
	so take the eg
									3
						5*					1^
					6		2			0		8
						7^		4^
	k = 2
	* -> target node
	^ -> result nodes at distance k from target
	like level 0 -> 5
	level 1 -> 6 2 3
	level 2 -> 7 4 1

	so basically we have use bfs as we want to go by levels for adding neigbor nodes
	Algo:
	1. we dont want to add repeated nodes to avoid infinite loop so hashset will contain seen nodes so far
	2. simple BFS where after polling node from queue add child nodes and parent to queue
		1. for parent we can save it to get it later -> say hashmap
	3. check for null nodes.
	4. and finally if level == k then current queue nodes are the result nodes as those are
	the nodes at that level.
	*/
	public static List<Integer> allNodes(TreeNode root, TreeNode target, int k) {
		// add parents to map
		Map<TreeNode, TreeNode> parents = new HashMap<>();
		dfsHelper(root, null, parents);

//		System.out.println(parents);
		int level = 0;
		// BFS
		Set<TreeNode> seen = new HashSet<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(target);
		seen.add(target);

		while (!que.isEmpty()) {
			// check for level
			if (level == k) {
				List<Integer> res = new ArrayList<>();
				for (TreeNode node : que) {
					res.add(node.val);
				}
				return res;
			}
			int size = que.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = que.poll();
				seen.add(curr);
				// add left child
				if (curr.left != null && !seen.contains(curr.left)) {
					que.offer(curr.left);
					seen.add(curr.left);
				}

				// add right child
				if (curr.right != null && !seen.contains(curr.right)) {
					que.offer(curr.right);
					seen.add(curr.right);
				}

				// add parent
				TreeNode par = parents.get(curr);
				if (par != null && !seen.contains(par)) {
					que.offer(par);
					seen.add(par);
				}
			}
			level++;
		}
		return new ArrayList<>();
	}

	private static void dfsHelper(TreeNode child, TreeNode parent, Map<TreeNode, TreeNode> parents) {
		if (child != null) {
			parents.put(child, parent);
			dfsHelper(child.left, child, parents);
			dfsHelper(child.right, child, parents);
		}
	}
}
