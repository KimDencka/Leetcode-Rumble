package kim.dencka.java.medium;

import java.util.*;

class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(input));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < lis.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : lis) max = Math.max(num, max);
        return max;
    }
}
