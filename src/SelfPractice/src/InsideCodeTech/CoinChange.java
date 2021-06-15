package InsideCodeTech;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2, 3, 7}; // 15
        int[] coins1 = {1, 2, 5}; // 11
//        System.out.println(coinChangeRec1(coins, 15));
//        System.out.println(coinChangeRec(coins, 15));
        System.out.println(coinChangeDP(coins1, 11));

    }

    static int coinChangeRec(int[] coins, int amt) {
        int minCoins = helperRec(coins, amt);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    // TC: m^n -> m (coins) and n(amt)
    // in tree, every n (amt) will have m branches (coins)
    // SC: n -> worst case (coin with 1 value) the tree will go amt depth
    private static int helperRec(int[] coins, int amt) {
        if (amt == 0)
            return 0;
        // -1 for overflow on line 27 i.e 1 + max value
        int minCoins = Integer.MAX_VALUE - 1;
        for (int coin : coins) {
            if (amt - coin >= 0)
                minCoins = Math.min(minCoins, 1 + helperRec(coins, amt - coin));
        }
        return minCoins;
    }

    public static int coinChangeRec1(int[] coins, int amount) {
        int min = helper(coins, amount);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int helper(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if ((amount - coin) >= 0) {
                int res = helper(coins, amount - coin);
                // another apporach to check for overflow
                if (res != Integer.MAX_VALUE)
                    min = Math.min(min, 1 + res);
            }
        }
        return min;
    }

    static int coinChangeDP(int[] coins, int amt) {
        int[] dp = new int[amt + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int minCoins = Integer.MAX_VALUE - 1;
            for (int coin : coins) {
                if (i - coin >= 0)
                    minCoins = Math.min(minCoins, 1 + dp[i - coin]);
            }
            dp[i] = minCoins;
        }
        return dp[amt] == Integer.MAX_VALUE - 1 ? -1 : dp[amt];
    }
}
