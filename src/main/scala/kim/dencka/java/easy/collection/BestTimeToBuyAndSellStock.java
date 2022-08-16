package kim.dencka.java.easy.collection;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 5, 4, 3, 2}));
    }

    public static int maxProfit(int[] prices) {
        int cur = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (cur - prices[i] > 0) {
                cur = prices[i];
            } else {
                int diff = Math.abs(cur - prices[i]);
                if (diff > res) {
                    res = diff;
                }
            }
        }
        return res;
    }
}
