package InsideCodeTech;

public class MaximumPathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(2);

        System.out.println(maxPathSum(root));
    }

    static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        helper(root, maxSum);
        return maxSum[0];
    }

    private static int helper(TreeNode root, int[] maxSum) {
        if (root == null)
            return 0;
        int left = helper(root.left, maxSum);
        int right = helper(root.right, maxSum);

        int maxFromTop = Math.max(root.data, Math.max(left, right));
        int maxNoTop = Math.max(maxFromTop, root.data + left + right);

        maxSum[0] = Math.max(maxSum[0], maxNoTop);
        return maxFromTop;
    }
}
