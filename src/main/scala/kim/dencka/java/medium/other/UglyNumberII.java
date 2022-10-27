package kim.dencka.java.medium.other;

class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int p = 1; p < n; p++) {
            dp[p] = Math.min(dp[i] * 2, Math.min(dp[j] * 3, dp[k] * 5));
            if (dp[p] == dp[i] * 2) i++;
            if (dp[p] == dp[j] * 3) j++;
            if (dp[p] == dp[k] * 5) k++;
        }
        return dp[n - 1];
    }
}
