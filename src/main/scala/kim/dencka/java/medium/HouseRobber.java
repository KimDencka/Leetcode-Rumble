package kim.dencka.java.medium;

class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{0, 1, 2, 0, 0, 3, 0, 0, 0, 1})); // 6
    }

    public static int rob(int[] nums) {
        int res = nums[0];
        int old = 0, cur;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] + old; // take
            old = res;           // skip
            res = Math.max(cur, res);
        }
        return res;
    }

    // DP; top-down
//    public static int rob(int[] nums) {
//        int n = nums.length;
//        int[] memo = new int[n];
//        Arrays.fill(memo, -1);
//        return bestFrom(n - 1, nums, memo);
//    }
//
//    private static int bestFrom(int i, int[] nums, int[] memo) {
//        if (i < 0) return 0;
//        if (memo[i] != -1) return memo[i];
//
//        int takeCurrent = bestFrom(i - 2, nums, memo) + nums[i];
//        int skipCurrent = bestFrom(i - 1, nums, memo);
//
//        memo[i] = Math.max(takeCurrent, skipCurrent);
//        return memo[i];
//    }

    // DP; bottom-up
//    public static int rob(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//
//        for (int i = 2; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//
//        return dp[n - 1];
//
//    }
}
