package medium;

import java.util.ArrayList;
import java.util.List;

public class BoundaryBinaryTree {
    static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(boundaries(root));

    }

    static List<Integer> boundaries(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        res.add(root.val);
        // get all nodes in left boundary
        getLeftBoundary(root.left);
        // if reached at leaves
        // get all the leaves
        getLeaves(root.left);
        getLeaves(root.right);

        // get all nodes on the right boundaries
        getRightBoundary(root.right);

        return res;
    }

    private static void getRightBoundary(TreeNode node) {
        if (node != null) {
            if (node.right != null) {
                getRightBoundary(node.right);
                res.add(node.val);
            } else if (node.left != null) {
                getRightBoundary(node.left);
                res.add(node.val);
            }
        }
    }

    private static void getLeaves(TreeNode node) {
        if (node != null) {
            getLeaves(node.left);

            if (node.left == null && node.right == null)
                res.add(node.val);

            getLeaves(node.right);
        }
    }

    private static void getLeftBoundary(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                res.add(node.val);
                getLeftBoundary(node.left);
            } else if (node.right != null) {
                res.add(node.val);
                getLeftBoundary(node.right);
            }
        }
    }
}
