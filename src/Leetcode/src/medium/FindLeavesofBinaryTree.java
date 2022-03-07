package medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);

		System.out.println(findLeaves1(root));
	}

	// using the node removal approach
	// keep on removing the leaf nodes and reiterate untill the root node is null
	// TC: every time truncated tree is iterated, the recursion is made untill height of tree
	// and every dfs visits all nodes N and it is happening while we reach the leaf node
	// i.e height of tree so nlogn -> logn is h
	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		while (root != null) {
			List<Integer> ls = new ArrayList<>();
			root = listofLeaves(root, ls);
			res.add(ls);
		}
		return res;
	}

	private static TreeNode listofLeaves(TreeNode root, List<Integer> ls) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			ls.add(root.val);
			return null;
		} else {
			TreeNode left = listofLeaves(root.left, ls);
			TreeNode right = listofLeaves(root.right, ls);
			root.left = left;
			root.right = right;
			return root;
		}
	}

	// using the height of both left subtree and right subtree
	// and calculating the level then
	// if we find that level at any node we add that node to that leveled index in our res
	// i.e res -> [[level 0 leaf nodes], [level 1 leaaf nodes], [so on], .....]
	// single iteration and single rescursion stack
	// TC: n

	public static List<List<Integer>> findLeaves1(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	private static int helper(TreeNode root, List<List<Integer>> res) {
		if (root == null)
			return -1;
		int level = 1 + Math.max(helper(root.left, res), helper(root.right, res));
		if (res.size() < level + 1)
			res.add(new ArrayList<>());
		res.get(level).add(root.val);
		return level;
	}
}
