package kim.dencka.java.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums))); // [24, 12, 8, 6]
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums2))); // [0, 0, 9, 0, 0]
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }
}
