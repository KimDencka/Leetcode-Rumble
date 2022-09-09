package kim.dencka.java.easy.collection;

import java.util.Arrays;

class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        int[] nums2 = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        moveZeroes(nums2);
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] == 0 & nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            if (nums[i] != 0) i++;
        }
        System.out.println(Arrays.toString(nums));
    }

    // alternative
//    int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//        if (nums[i] != 0) {
//            nums[j] = nums[i];
//            j++;
//        }
//    }
//        for (int i = j; i < nums.length; i++)
//    nums[i] = 0;
}

