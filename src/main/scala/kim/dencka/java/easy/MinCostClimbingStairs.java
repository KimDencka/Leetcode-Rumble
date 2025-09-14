package kim.dencka.java.easy;

class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 2) return Math.min(cost[0], cost[1]);
        int first = 0;
        int second = 0;
        for (int c : cost) {
            int cur = c + Math.min(first, second);
            first = second;
            second = cur;
        }

        return Math.min(first, second);
    }
}
