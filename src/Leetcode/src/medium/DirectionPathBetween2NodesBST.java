package medium;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode() {
	}
}
// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/discuss/1612105/3-Steps
public class DirectionPathBetween2NodesBST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(8);
		root.right.right = new TreeNode(7);

//		System.out.println(getDirections(root, 3, 6));
		System.out.println(getDirection(root, 4, 8));
	}

	private static boolean find(TreeNode n, int val, StringBuilder sb) {
		if (n.val == val)
			return true;
		if (n.left != null && find(n.left, val, sb))
			sb.append("L");
		else if (n.right != null && find(n.right, val, sb))
			sb.append("R");
		return sb.length() > 0;
	}

	public static String getDirection(TreeNode root, int startValue, int destValue) {
		StringBuilder s = new StringBuilder(), d = new StringBuilder();
		find(root, startValue, s);
		find(root, destValue, d);
		int i = 0, max_i = Math.min(d.length(), s.length());
		// checking for common ancestor and updting the index we want to use for d's path
		while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
			i++;
//		System.out.println(s);
//		System.out.println(d);
		return "U".repeat(s.length() - i) + d.reverse().substring(i);
	}
}
