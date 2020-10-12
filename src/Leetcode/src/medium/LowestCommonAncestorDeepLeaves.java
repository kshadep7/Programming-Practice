package medium;

class Pair {
    TreeNode node;
    int height;

    public Pair(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}

public class LowestCommonAncestorDeepLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.left.left = new TreeNode(8);
//        root.right.left.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        System.out.println(findAncestor(root).val);
    }

    // using height approach
    static TreeNode findAncestor(TreeNode root) {
        Pair ans = helper(root, 0);
        return ans.node;
    }

    private static Pair helper(TreeNode root, int height) {
        if (root == null)
            return new Pair(null, height);

        Pair left = helper(root.left, height + 1);
        Pair right = helper(root.right, height + 1);

        if (left.height == right.height)
            return new Pair(root, left.height);
        else
            return left.height > right.height ? left : right;
    }
 }
