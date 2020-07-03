package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Add2BinaryTrees {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);


//        printTree(addTreesRec(t1, t2));
        printTree(addTrees(t1, t2));
    }

    static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    //recursive
    // can also be done using new 3rd tree
    static TreeNode addTreesRec(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = addTreesRec(t1.left, t2.left);
        t1.right = addTreesRec(t1.right, t2.right);

        return t1;
    }

    // iterative BFS
    static TreeNode addTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;

        if (t1 == null) return t2;
        if (t2 == null) return t1;

//        TreeNode newNode = new TreeNode();
        Queue<TreeNode[]> que = new LinkedList<>();
        que.offer(new TreeNode[]{t1, t2});
        while (!que.isEmpty()) {
            TreeNode[] currPair = que.poll();
            if (currPair[1] == null)
                continue;
            currPair[0].val += currPair[1].val;
            if (currPair[0].left == null)
                currPair[0].left = currPair[1].left;
            else que.offer(new TreeNode[]{currPair[0].left, currPair[1].left});

            if (currPair[0].right == null)
                currPair[0].right = currPair[1].right;
            else que.offer(new TreeNode[]{currPair[0].right, currPair[1].right});
        }
        return t1;
    }
}
