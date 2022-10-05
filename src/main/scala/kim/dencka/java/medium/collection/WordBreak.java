package kim.dencka.java.medium.collection;

import java.util.*;

class WordBreak {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("leeet");
        input.add("code");
        System.out.println(wordBreak("leeetcodeleeet", input));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= n && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
}
