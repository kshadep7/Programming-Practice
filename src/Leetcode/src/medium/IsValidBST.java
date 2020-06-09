package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {
    static List<Double> list = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
//        node.left.left = new TreeNode(2);
//        node.left.right = new TreeNode(4);
//        node.left.left.left = new TreeNode(1);
//        node.right.left = new TreeNode(6);
//        node.right.right = new TreeNode(8);

//        System.out.println(isValid(node));
        list.add(-Double.MAX_VALUE);
//        System.out.println(valid(node, list, 0) != -1);
        System.out.println(inOrder(node, new ArrayList<>()));

    }

    static boolean isValid(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= pre) return false;
            pre = node.val;
            node = node.right;
        }
        return true;
    }

    //using recursion
    static int valid(TreeNode node, List<Double> list, int index) {

        if (node == null)
            return index;

        index = valid(node.left, list, index);
        if (node.val <= list.get(index)) {
            index = -1;
            return index;
        }
        list.remove(index);
        list.add((double) node.val);

        index = valid(node.right, list, index);

        return index;
    }

    static List<Double> inOrder(TreeNode node, List<Double> list) {
        if (node == null) {
            return list;
        }

        list = inOrder(node.left, list);
        list.add((double) node.val);
        list = inOrder(node.right, list);

        return list;
    }
}
