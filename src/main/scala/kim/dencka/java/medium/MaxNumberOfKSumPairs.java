package kim.dencka.java.medium;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        System.out.println(maxOperations(nums, k));

        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.println(maxOperations(nums2, k2));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            } else {
                result++;
                l++;
                r--;
            }
        }
        return result;
    }
}
