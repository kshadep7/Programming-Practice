package easy;

import java.util.*;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
/**
 *   s  =>              3
 *                 /        \
 *               4           5
 *              / \        /   \
 *            1    2     (-1)  (-1)
 *           /    / \
 *        (-1)   0  (-1)
 *
 *    t =>          4
 *                /  \
 *               1    2
 * */
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.right = new TreeNode(5);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);



        System.out.println(isSub(s, t));

    }

    // TC: log(s) -> recursive goes the entire depth of s
    //      worst case O(n) if s is skewed ..n is all nodes in s
    // SC: stack space -> recursive calls will be equal depth of s same as TC
    static boolean isSub(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        return isSame(s, t) ||
                isSub(s.left, t) ||
                isSub(s.right, t);
    }

    static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;

        return isSame(s.left, t.left) &&
                isSame(s.right, t.right);
    }


    // wont work as we need to check the structure of the tree and subtree
    static boolean isSubTree(TreeNode s, TreeNode t) {
        // idea is to convert both trees into lists
        //check if sublist(t) contains in list(s)
        //assuming only positive integers
        if (s == null || t == null)
            return false;

        List<Integer> sList = new ArrayList<>();
        List<Integer> tList = new ArrayList<>();

        inOrder(s, sList);
        inOrder(t, tList);

        System.out.println(sList);
        System.out.println(tList);

        return Collections.indexOfSubList(sList, tList) != -1;
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(-1);
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

}
