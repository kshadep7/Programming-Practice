package medium;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        this.stack = new Stack<>();
        this.leftMostNodes(root);

    }

    private void leftMostNodes(TreeNode node) {
        // stack will only contains node which complies with O(h) space --> h being height of tree
        while (node != null) {
            this.stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode temp = stack.pop();
// technically average TC is O(1) and also if tree is skewed
        if (temp.right != null)
            this.leftMostNodes(temp.right);

        return temp.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
