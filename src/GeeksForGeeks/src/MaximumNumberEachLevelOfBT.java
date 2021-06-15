import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumNumberEachLevelOfBT {

        /*
         Given a binary tree, find all max values  at each level

         Input:
             4
            / \
           9   2
          / \   \
         3   5   7
         Output:
         4 9 7
         Explanation:
         At 0 level, values of nodes are {4}
         Maximum value is 4
         At 1 level, values of nodes are {9,2}
         Maximum value is 9
         At 2 level, values of nodes are {3,5,7}
         Maximum value is 7
         */
        public static void main(String[] args) {

                TreeNode node = new TreeNode(4);
                node.left = new TreeNode(9);
                node.right = new TreeNode(2);
                node.right.right = new TreeNode(7);
                node.left.left = new TreeNode(3);
                node.left.right = new TreeNode(5);

                System.out.println(maxNumAtEachLevel(node));
                System.out.println(maximumValue(node));
        }

        static List<Integer> maxNumAtEachLevel(TreeNode node) {
                // using custom BFS algo
                // keep a track of max number at each level
                // keep track of level as well

                if (node == null)
                        return new ArrayList<>();

                Queue<TreeNode> que = new LinkedList<>();
                que.offer(node);
                List<Integer> res = new ArrayList<>();
                int nodeCount = 0;
                while (true) {
                        // tracking level i.e no of nodes on the level
                        nodeCount = que.size();
                        if (nodeCount == 0)
                                break;

                        int max = Integer.MIN_VALUE;
                        while (nodeCount != 0) {
                                TreeNode temp = que.poll();
//                assert temp != null;
                                max = Math.max(temp.val, max);
                                if (temp.left != null)
                                        que.offer(temp.left);
                                if (temp.right != null)
                                        que.offer(temp.right);

                                nodeCount--;
                        }
                        res.add(max);
                }

                return res;
        }

        //using dfs
        // keeping track of levels
        static void solve(TreeNode node, int level, ArrayList<Integer> answer) {
                if (node == null)
                        return;
                if (level == answer.size())
                        answer.add(node.val);
                else {
                        if (answer.get(level) < node.val) {
                                answer.set(level, node.val);
                        }
                }
                solve(node.left, level + 1, answer);
                solve(node.right, level + 1, answer);
        }

        static ArrayList<Integer> maximumValue(TreeNode node) {
                ArrayList<Integer> answer = new ArrayList<>();
                solve(node, 0, answer);
                return answer;
        }


}
