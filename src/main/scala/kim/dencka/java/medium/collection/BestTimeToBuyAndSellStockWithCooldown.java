package kim.dencka.java.medium.collection;

class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 0, 2, 3, 0, 2}));
    }

    public static int maxProfit(int[] prices) {
        int buy = -prices[0];
        int old = 0;
        int cur = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(old - prices[i], buy);
            old = cur;
            cur = Math.max(buy + prices[i], cur);
        }
        return cur;
    }
}
