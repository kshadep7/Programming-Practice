package easy;

public class BuyAndSellStock {

    public static void main(String[] args) {

        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit1(arr));
    }

    // n2
    static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    //n
    static int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int price : prices) {
            if (price < min)
                min = price;
            else if (price - min > max)
                max = price - min;
        }
        return max;
    }
}
