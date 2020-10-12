package InsideCodeTech;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS2 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(1);
        root.left.right.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);

        System.out.println(bfs2(root));
    }

    static List<List<Integer>> bfs2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                if (temp.left != null)
                    que.offer(temp.left);
                if (temp.right != null)
                    que.offer(temp.right);
                level.add(temp.data);
            }
            res.add(level);
        }
        return res;
    }
}
