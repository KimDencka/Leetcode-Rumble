package kim.dencka.java.medium;

import java.util.*;

class BagOfTokens {
    public static void main(String[] args) {
        int[] input = {100, 200, 300, 400};
        System.out.println(bagOfTokensScore(input, 200));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int cur = 0;
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i];
                cur++;
                i++;
            } else if (score > 0) {
                cur--;
                power += tokens[j];
                j--;
            } else return score;
            score = Math.max(score, cur);
        }

        return score;
    }
}
