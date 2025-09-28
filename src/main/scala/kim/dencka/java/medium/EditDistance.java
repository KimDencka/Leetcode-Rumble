package kim.dencka.java.medium;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        char[] str1 = word1.toCharArray(), str2 = word2.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        for (int r = 1; r <= n; r++) dp[r][0] = r; // dp[r][0] = r: transforming word1[0...r-1] into an empty string requires r deletions.
        for (int c = 1; c <= m; c++) dp[0][c] = c; // dp[0][c] = c: transforming an empty string into word2[0...c-1] requires c insertions.

        for (int r = 1; r <= n; r++) {
            char a = str1[r - 1];
            for (int c = 1; c <= m; c++) {
                char b = str2[c - 1];
                if (a == b) {
                    dp[r][c] = dp[r - 1][c - 1]; // no operation needed
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r - 1][c], dp[r][c - 1])) + 1;
                    // dp[r-1][c-1] + 1 - replace the character at position r-1 in word1 with the character at position c-1 in word2.
                    // dp[r-1][c] + 1   - delete the character at position r-1 in word1.
                    // dp[r][c-1] + 1   - insert the character at position c-1 in word2 into word1 at position i.
                }
            }
        }

        return dp[n][m];
    }
}

