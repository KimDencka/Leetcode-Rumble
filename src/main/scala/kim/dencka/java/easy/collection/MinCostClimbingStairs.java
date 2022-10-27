package kim.dencka.java.easy.collection;

class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 2) return Math.min(cost[0], cost[1]);
        int old = 0;
        int cur = 0;
        int step;
        for (int j : cost) {
            step = j + Math.min(old, cur);
            old = cur;
            cur = step;
        }
        return Math.min(old, cur);
    }
}
