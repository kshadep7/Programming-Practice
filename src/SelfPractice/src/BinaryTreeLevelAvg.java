
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    TreeNode left, right;
    int val;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeLevelAvg {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelAvg(root));

    }

    static List<Integer> levelAvg(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> out = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
//                assert curr != null;
                sum += curr.val;
                if (i == size - 1)
                    out.add(sum / size);

                if (curr.left != null)
                    que.offer(curr.left);
                if (curr.right != null)
                    que.offer(curr.right);
            }
        }
        return out;
    }
}
