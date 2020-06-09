package medium;

public class ConvertBSTtoDLL {
    static TreeNode prev = null;

    public static void main(String[] args) {

    }

    static TreeNode convert(TreeNode root) {
        // for edge case
        if (root == null) return null;
        TreeNode dummy = new TreeNode(0, null, null);
        prev = dummy;
        //connect BST
        helper(root);
        // connecting last prev i.e last node to first node i.e dummy's right's left
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy;
    }

    static void helper(TreeNode curr) {
        if (curr == null)
            return;
        // go left -- deep
        helper(curr.left);
        prev.right = curr;
        curr.left = prev;
        prev = curr;
        // go right
        helper(curr.right);
    }
}
