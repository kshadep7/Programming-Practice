package medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DeppestLeavesSum {
	static int sum = 0;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(7);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(9);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);

		// deepestLeavesSum(root);
		// deep(root);
		HashMap<Integer, Integer> hm = new HashMap<>();
		helper(root, 0, hm);
		Integer maxKey = Collections.max(hm.keySet());
		System.out.println(hm.get(maxKey));

	}

	public static void deepestLeavesSum(TreeNode root) {

		int sum = 0;

		Queue<TreeNode> q = new LinkedList<>();

		if (root != null)
			q.add(root);

		while (!q.isEmpty()) {
			sum = 0;
			int size = q.size();
			for (int i = size; i > 0; i--) {
				TreeNode temp = q.poll();
				sum += temp.val;
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}

		System.out.println(sum);
	}

	public static void deep(TreeNode root) {
		int dep = getDepth(root);
		System.out.println(getSumAtLevel(root, dep));

	}

	static int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		System.out.println(root.val);
		return 1 + Math.max(getDepth(root.right), getDepth(root.left));
	}

	static int getSumAtLevel(TreeNode root, int level) {
		if (root == null)
			return 0;
		if (level == 1)
			return root.val;
		System.out.println(root.val + "-->" + level);
		return getSumAtLevel(root.left, level - 1) + getSumAtLevel(root.right, level - 1);
	}

	// using hashmap and recursion
	public static void helper(TreeNode root, int level, HashMap<Integer, Integer> hm) {
		System.out.println(root.val);

		Integer prev = hm.get(level);
		if (prev != null) {
			hm.put(level, prev + root.val);
		} else {
			hm.put(level, root.val);
		}

		System.out.println(hm);

		if (root.left != null) {
			helper(root.left, level + 1, hm);
		}
		if (root.right != null) {
			helper(root.right, level + 1, hm);
		}
	}

}
