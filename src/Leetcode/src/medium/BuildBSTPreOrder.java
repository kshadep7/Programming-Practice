package medium;

import java.util.Stack;

public class BuildBSTPreOrder {
	static int i = 0;

	public static void main(String[] args) {

		int[] arr = { 8, 5, 1, 7, 10, 12 };
		// int[] arr = { 8, 7, 1, 5, 10, 12 };

		// preOrder(bstFromPreorder(arr));
		preOrder(build2(arr));

	}

	public static TreeNode bstFromPreorder(int[] arr) {

		return helper(arr, Integer.MAX_VALUE);
	}

	static TreeNode helper(int[] arr, int maxValue) {
		if (i == arr.length || arr[i] > maxValue)
			return null;

		TreeNode root = new TreeNode(arr[i]);
		i++;
		root.left = helper(arr, root.val);
		root.right = helper(arr, maxValue);

		return root;

	}

	static void preOrder(TreeNode root) {

		if (root == null)
			return;

		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	// using stack

	static TreeNode build(int[] arr) {

		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(arr[0]);
		stack.push(root);

		for (int i = 1; i < arr.length; i++) {
			TreeNode temp = null;
			while (!stack.isEmpty() && arr[i] > stack.peek().val) {
				temp = stack.pop();
			}
			if (temp != null) {
				temp.right = new TreeNode(arr[i]);
				stack.push(temp.right);
			} else {
				temp = stack.peek();
				temp.left = new TreeNode(arr[i]);
				stack.push(temp.left);
			}
		}
		return root;
	}

	static TreeNode build2(int[] arr) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(arr[0]);
		stack.push(root);
		int i = 1;

		while (!stack.isEmpty() && i < arr.length) {
			TreeNode temp = stack.peek();
			if (arr[i] < temp.val) {
				temp.left = new TreeNode(arr[i]);
				stack.push(temp.left);
			} else {
				while (!stack.isEmpty() && arr[i] > stack.peek().val) {
					temp = stack.pop();
				}
				temp.right = new TreeNode(arr[i]);
				stack.push(temp.right);
			}
			i++;
		}
		return root;

	}
}
