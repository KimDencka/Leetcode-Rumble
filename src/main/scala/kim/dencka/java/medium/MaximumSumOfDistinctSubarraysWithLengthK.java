package kim.dencka.java.medium;

import java.util.HashMap;
import java.util.Map;

class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] input = new int[]{1, 5, 4, 2, 9, 9, 9};
        System.out.println(maximumSubarraySum(input, 3)); // 15
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long max = 0, sum = 0;
        int fi = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i - fi + 1 == k) {
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }
                sum -= nums[fi];
                map.put(nums[fi], map.getOrDefault(nums[fi], 0) - 1);
                if (map.get(nums[fi]) <= 0) map.remove(nums[fi]);
                fi++;
            }
        }
        return max;
    }
}
