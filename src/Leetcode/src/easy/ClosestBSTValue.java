package easy;

import java.util.LinkedList;

public class ClosestBSTValue {

    public static void main(String[] args) {

    }
    // using bfs - TC: O(N), SC: O(N)
    public int closestValue(TreeNode root, double target) {
        double min = Integer.MAX_VALUE;
        int ans = root.val;
        //using bfs and checking for lowest difference
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            TreeNode node = q.poll();
            double diff = Math.abs(node.val-target);
            if(diff < min){
                min = diff;
                ans = node.val;
            }

            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }

        return ans;
    }


}
