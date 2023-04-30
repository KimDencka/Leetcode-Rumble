package kim.dencka.java.easy.collection;

import java.util.*;

class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] input = new int[]{-1, 10, 6, 7, -7, 1};
        System.out.println(findMaxK(input));
        // expected: 7
    }

    public static int findMaxK(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                if (!set.isEmpty() && set.contains(num * -1)) {
                    max = Math.max(max, Math.abs(num));
                } else set.add(num);
            } else {
                if (!set.isEmpty() && set.contains(num * -1)) {
                    max = Math.max(max, Math.abs(num));
                } else set.add(num);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
