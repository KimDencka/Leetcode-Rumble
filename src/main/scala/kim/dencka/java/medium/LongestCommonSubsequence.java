package kim.dencka.java.medium;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        char[] str1 = text1.toCharArray(), str2 = text2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        for (int r = 1; r <= n; r++) {
            char a = str1[r - 1];
            for (int c = 1; c <= m; c++) {
                char b = str2[c - 1];
                if (a == b) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                } else {
                    dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
