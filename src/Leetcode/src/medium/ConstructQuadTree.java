package medium;


import java.util.*;

// Definition for a QuadTree node.
class QNode {
    public boolean val;
    public boolean isLeaf;
    public QNode topLeft;
    public QNode topRight;
    public QNode bottomLeft;
    public QNode bottomRight;


    public QNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QNode(boolean val, boolean isLeaf, QNode topLeft, QNode topRight, QNode bottomLeft, QNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class ConstructQuadTree {

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        QNode res = construct(grid);
        System.out.println(printQNode(res));
    }

    static QNode construct(int[][] grid) {
        int n = grid.length - 1;
        return helper(grid, 0, 0, n, n);
    }

    private static QNode helper(int[][] grid, int r1, int c1, int r2, int c2) {
        if (r1 > r2 || c1 > c2)
            return null;

        boolean isLeaf = true;
        int val = grid[r1][c1];
        a:
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (val != grid[i][j]) {
                    isLeaf = false;
                    break a;
                }
            }
        }

        if (isLeaf)
            return new QNode(val == 1, true);

        int midR = (r1 + r2) / 2;
        int midC = (c1 + c2) / 2;

        return new QNode(false, false,
                helper(grid, r1, c1, midR, midC),
                helper(grid, r1, midC + 1, midR, c2),
                helper(grid, midR + 1, c1, r2, midC),
                helper(grid, midR + 1, midC + 1, r2, c2));
    }

    //using BFS
    public static List<String> printQNode(QNode root) {
        Queue<QNode> que = new LinkedList<>();
        que.offer(root);
        List<String> res = new ArrayList<>();
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                QNode temp = que.poll();
                int[] arr = new int[]{temp.val ? 1 : 0, temp.isLeaf ? 1 : 0};
                res.add(Arrays.toString(arr));
                if (temp.topLeft != null)
                    que.offer(temp.topLeft);

                if (temp.topRight != null)
                    que.offer(temp.topRight);

                if (temp.bottomLeft != null)
                    que.offer(temp.bottomLeft);

                if (temp.bottomRight != null)
                    que.offer(temp.bottomRight);
            }
        }
        return res;
    }
}
