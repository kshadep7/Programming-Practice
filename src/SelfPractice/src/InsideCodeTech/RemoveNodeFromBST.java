package InsideCodeTech;

import java.util.ArrayList;
import java.util.List;

public class RemoveNodeFromBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(10);
        root.left.right.right.left = new TreeNode(8);
        root.left.right.right.right = new TreeNode(11);
        root.left.right.right.left.left = new TreeNode(7);
        root.right = new TreeNode(23);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(38);

        inOrder(root);
        removeNode(root, 5);
        System.out.println("\n");
        inOrder(root);
    }

    static TreeNode removeNode(TreeNode root, int x) {
        if (root == null)
            return null;
        else if (root.data > x)
            root.left = removeNode(root.left, x);
        else if (root.data < x)
            root.right = removeNode(root.right, x);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode nextLowestNode = getNext(root.right);
                root.data = nextLowestNode.data;
                root.right = removeNode(root.right, nextLowestNode.data);
            }
        }
        return root;
    }

    private static TreeNode getNext(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private static void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

}
