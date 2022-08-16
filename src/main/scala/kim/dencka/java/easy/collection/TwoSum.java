package kim.dencka.java.easy.collection;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 2, 0, 0, 0, 0, 6, 0, 0};
        System.out.println(Arrays.toString(twoSum(nums, 8)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
