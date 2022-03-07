package InsideCodeTech;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(findLowest(root, 3, 4));
	}

	// TC: n -> all nodes
	// SC: h -> height of tree -> call stack
	static int findLowest(TreeNode root, int num1, int num2) {
		if (root == null)
			return -1;
		// for storing paths for num1 and 2
		List<Integer> pathForNum1 = new ArrayList<>();
		List<Integer> pathForNum2 = new ArrayList<>();
		// no path for anyone of num1 and 2 then no solution
		if (!isPath(root, num1, pathForNum1) || !isPath(root, num2, pathForNum2))
			return -1;

		//get min len of 2 paths
		int minLen = Math.min(pathForNum1.size(), pathForNum2.size());
		int i = 0;
		// check for first different value
		// and return last found same value position for eg.
		// path1 -> [1,3,6]     --> break at 6≠7 and return 3
		// path2 -> [1,3,7]
		while (i < minLen) {
			if (pathForNum1.get(i).equals(pathForNum2.get(i)))
				i++;
			else
				break;
		}
		return pathForNum1.get(i - 1);
	}

	private static boolean isPath(TreeNode root, int num, List<Integer> pathForNum) {
		if (root == null)
			return false;
		pathForNum.add(root.data);
		if (root.data == num) {
			return true;
		}
		if (isPath(root.left, num, pathForNum) || isPath(root.right, num, pathForNum))
			return true;
		pathForNum.remove(pathForNum.size() - 1);

		return false;
	}

	//approach 2:
	// checking where num1 and num2 are present i.e. in which subtree, left or right
	static TreeNode LCA(TreeNode root, int num1, int num2) {
		// base case
		if (root == null)
			return null;
		// check if node is num1 or 2
		if (root.data == num1 || root.data == num2)
			return root;
		// go left check for num1 or num2
		TreeNode leftLCA = LCA(root.left, num1, num2);
		// go right check for num1 or num2
		TreeNode rightLCA = LCA(root.right, num1, num2);
		// if both num1 and 2 are found return root
		if (leftLCA != null && rightLCA != null)
			return root;
		// return left node if found or watever is on right
		return leftLCA != null ? leftLCA : rightLCA;
	}



}
