package medium;
/*
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, root;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class SumofNodesEvenGrandParent {

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

        sumEvenGrandparent(root);
    }

    public static void sumEvenGrandparent(TreeNode root) {

        // using bfs
        int sum = 0;
        Queue<Pair<TreeNode, Boolean>> que = new LinkedList<>();

        if (root != null) {
            que.add(new Pair(root, false));
            // level = 0;
        }

        while (!que.isEmpty()) {

            Pair<TreeNode, Boolean> pair = que.poll();
            TreeNode temp = pair.getKey();
            boolean isEvenParent = temp.val % 2 == 0, isEvenGrandP = pair.getValue();
            for (TreeNode child : new TreeNode[]{temp.left, temp.right}) {
                if (child != null) {
                    que.add(new Pair(child, isEvenParent));
                    sum += isEvenGrandP ? child.val : 0;
                }
            }
        }
        System.out.println(sum);
    }
}
*/
