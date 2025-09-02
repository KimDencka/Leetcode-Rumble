package kim.dencka.java.medium;

class CountWaysToBuildGoodStrings {
    public static void main(String[] args) {
        System.out.println(countGoodStrings(3, 3, 1, 1));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int cnt = 0, MOD = 1000000007;
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = (dp[i] + dp[i - zero]) % MOD;
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % MOD;
            if (i >= low) cnt = (dp[i] + cnt) % MOD;
        }
        return cnt;
    }
}
