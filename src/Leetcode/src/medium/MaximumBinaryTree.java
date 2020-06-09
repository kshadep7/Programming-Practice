package medium;

public class MaximumBinaryTree {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 2, 1, 6, 0, 5 };
		constructMaximumBinaryTree(arr);

	}

	public static void constructMaximumBinaryTree(int[] arr) {
		TreeNode root = build(arr, 0, arr.length - 1);
		printTree(root);
	}

	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);

	}

	public static TreeNode build(int[] nums, int low, int high) {

		if (low > high)
			return null;

		int maxValue = Integer.MIN_VALUE, maxIndex = -1;
		// finding max value and its index in nums
		for (int i = low; i <= high; i++) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				maxIndex = i;
			}
		}

		// creating a root node with above max value
		TreeNode node = new TreeNode(nums[maxIndex]);
		if (maxIndex > low)
			node.left = build(nums, low, maxIndex - 1);
		if (maxIndex < high)
			node.right = build(nums, maxIndex + 1, high);

		return node;
	}

}
