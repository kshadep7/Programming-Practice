package InsideCodeTech;

public class ValidBinarySearchTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(16);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(19);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(6);
        root.right = new TreeNode(22);

//        System.out.println(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isValid1(root));
    }

    // using min and max apporach
    static boolean isValid(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        else if (root.data <= min || root.data >= max)
            return false;

        return isValid(root.left, min, root.data) &&
                isValid(root.right, root.data, max);
    }

    // using inorder approach
    // as BST converted to array using inorder traversal is a sorted
    // so next node value is always greater than previous node value
    static boolean isValid1(TreeNode root) {
        int[] arr = new int[]{Integer.MIN_VALUE};
        return helper(root, arr);
    }

    // modified inorder
    static boolean helper(TreeNode root, int[] arr) {
        if (root == null)
            return true;
        if (!helper(root.left, arr))
            return false;
        if (root.data <= arr[0])        // here we check next node value with previous one
            return false;
        else
            arr[0] = root.data;
        if (!helper(root.right, arr))
            return false;

        return true;

    }
}
