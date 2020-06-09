package medium;

import java.util.LinkedList;
import java.util.Stack;

public class DeleteTargetLeafNode {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);

//		printTree(root);
//		deleteNode(root, 2);
		deleteNodeStack(root, 2);
		System.out.println("\n");
		printTree(root);

	}
	
	static void deleteNodeStack(TreeNode root, int target) {
		
//		if(root == null)
//			return null;
		
//		TreeNode tree = new TreeNode(root.val);
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode parent;
		boolean flag = false;
		stack.push(root);
		while(!stack.isEmpty()) {
			
			TreeNode temp = stack.pop();
//			parent = temp;
			if(temp.right != null) {
				stack.push(temp.right);
			}
			
			if(temp.left != null) {
				stack.push(temp.left);
			}
			
			if(temp.left == null && temp.right == null && temp.val == target) {
				temp = null;
			}
		}
		
		
	}
// recursive
	static TreeNode deleteNode(TreeNode root, int target) {

		System.out.println(root.val);
		if (root.left != null)
			root.left = deleteNode(root.left, target);
		if (root.right != null)
			root.right = deleteNode(root.right, target);
		return root.left == root.right && root.val == target ? null : root;
	}

	static void printTree(TreeNode root) {

		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.val + " ");
		printTree(root.right);
	}
}
