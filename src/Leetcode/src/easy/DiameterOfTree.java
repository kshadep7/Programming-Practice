package easy;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class DiameterOfTree {
    // Diameter of the tree is the longest length of path between any 2 node in a binary tree.
    static int max = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameter(root));

    }

    static int diameter(TreeNode node) {
        if (node == null)
            return 0;
        dfs(node);
        return max;
    }

    static int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int L = dfs(node.left);
        int R = dfs(node.right);

        max = Math.max(max, L + R);
        return Math.max(L, R) + 1;

    }
}
