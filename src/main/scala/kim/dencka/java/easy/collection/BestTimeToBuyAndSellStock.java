package kim.dencka.java.easy.collection;

class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 5, 4, 3, 2}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int j = 0;
        int diff;
        for (int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[j];
            if (diff < 0) j = i;
            else maxProfit = Math.max(maxProfit, diff);
        }
        return maxProfit;
    }

    // THE SAME SOLUTION
//    public static int maxProfit(int[] prices) {
//        int cur = prices[0];
//        int res = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if (cur - prices[i] > 0) {
//                cur = prices[i];
//            } else {
//                int diff = Math.abs(cur - prices[i]);
//                if (diff > res) {
//                    res = diff;
//                }
//            }
//        }
//        return res;
//    }
}
