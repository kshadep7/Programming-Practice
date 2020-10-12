package InsideCodeTech;

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(9);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(isBTBal(root, new int[1]));

    }

    // balanced BT meaning (hieght of left subtree) - (height of right subtree) <= 1
    // apprach is to find height of from all the nodes as root
    // and check is above condition
    //TC : n2 -> as traversing all nodes for isBSTBalanced
    // and inside finding height for every isBSTBalanced
    //SC: h-> height of tree ->call stack
    static boolean isBTBalanced(TreeNode root) {

        int leftHeight = 0;
        int rightHeight = 0;

        //finsing height of both left and right subtrees
        leftHeight = height(root.left);
        rightHeight = height(root.right);

        // check for condition and recurse for inner subtrees (left and right)
        if (Math.abs(leftHeight - rightHeight) <= 1
                && isBTBalanced(root.left) && isBTBalanced(root.right))
            return true;

        return false;
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    // using arrays for heights -> height are used as references (pass by ref concept)
    // TC: n
    // SC: h -> call stack of height of tree
    static boolean isBTBal(TreeNode root, int[] height) {
        if (root == null)
            return true;

        // initialize both heights
        int[] leftHeight = new int[1];
        int[] rightHeight = new int[1];

        // check left and right subtress is balanced using dfs
        boolean isLeftSubtreeBal = isBTBal(root.left, leftHeight);
        boolean isRightSubtreeBal = isBTBal(root.right, rightHeight);

        // calculate the height for subtress
        height[0] = 1 + Math.max(leftHeight[0], rightHeight[0]);

        //check for conditions and return
        return Math.abs(leftHeight[0] - rightHeight[0]) <= 1
                && isLeftSubtreeBal && isRightSubtreeBal;
    }
}
