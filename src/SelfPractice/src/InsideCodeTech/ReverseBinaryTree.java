package InsideCodeTech;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left, right;
    int data;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ReverseBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.left.left.right = new TreeNode(3);

        printTree(root);
        reverse(root);
        printTree(root);
    }

    static void reverse(TreeNode root) {

        if (root == null)
            return;
        // swap childs
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // do same for its child trees
        reverse(root.left);
        reverse(root.right);
    }

    static void printTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> nodes;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    que.offer(temp.left);
                if (temp.right != null)
                    que.offer(temp.right);
            }
            System.out.println("\n");
        }
    }
}
