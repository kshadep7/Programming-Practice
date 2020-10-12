package InsideCodeTech;

public class FlattenBTtoLinkedList {

    // do it in-place
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

//        printTree(flattenToLL(root));
        printTree(convert(root));
    }

    static void printTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    // TC: n -> no of nodes
    static TreeNode flattenToLL(TreeNode root) {
        // base case
        if (root == null)
            return root;

        // go left
        flattenToLL(root.left);
        // go right
        flattenToLL(root.right);
        // save right sub tree / right node of root
        TreeNode rightSubtree = root.right;
        // make root's right == root's left
        root.right = root.left;
        // make root's left null
        root.left = null;
        // find root's right most leaf node and append saved right sub tree
        TreeNode temp = root;
        while (temp.right != null)
            temp = temp.right;
        temp.right = rightSubtree;

        return root;
    }

    static TreeNode convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        convert(root.left);
        convert(root.right);

        TreeNode rightSub = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode temp = root;
        while (temp.right != null)
            temp = temp.right;
        temp.right = rightSub;

        return root;
    }
}
