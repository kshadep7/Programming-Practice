public class ConstructionManagement {

    public static void main(String[] args) {
        int[][] cost = {{1, 2, 2}, {2, 2, 1}, {2, 1, 2}};
        int[][] cost1 = {{1, 2, 2}, {2, 3, 3}, {3, 3, 1}};

        System.out.println(minCost(cost1));
    }

    static int minCost(int[][] cost) {
        for (int i = 1; i < cost.length; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
        }
        int n = cost.length;
        return Math.min(cost[n - 1][0], Math.min(cost[n - 1][1], cost[n - 1][2]));
    }

}
