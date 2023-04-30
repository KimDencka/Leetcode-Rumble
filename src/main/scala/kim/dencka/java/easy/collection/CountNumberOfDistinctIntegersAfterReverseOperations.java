package kim.dencka.java.easy.collection;

import java.util.*;

class CountNumberOfDistinctIntegersAfterReverseOperations {
    // Count Number of Distinct Integers After Reverse Operations
    public static void main(String[] args) {
        int[] input = new int[]{1, 13, 10, 12, 31};
        System.out.println(countDistinctIntegers(input));
        // expected: 6
    }

    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int reversed = reverse(num);
            set.add(reversed);
        }
        return set.size();
    }

    private static int reverse(int num) {
        int r = 0;
        while (num != 0) {
            r = r * 10 + num % 10;
            num /= 10;
        }
        return r;
    }
}
