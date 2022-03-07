package easy;

public class IsSameTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(7);
		root2.left.right = new TreeNode(5);

		System.out.println(isSameTree(root1, root2));


	}

	public static boolean isSameTree(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;
		if (a.val != b.val)
			return false;

		return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);

	}
}
