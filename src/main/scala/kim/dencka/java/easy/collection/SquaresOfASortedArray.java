package kim.dencka.java.easy.collection;

import java.util.*;

class SquaresOfASortedArray {

    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0, r = nums.length - 1;
        int i = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                result[i--] = nums[l] * nums[l];
                l++;
            } else {
                result[i--] = nums[r] * nums[r];
                r--;
            }
        }
        return result;
    }
}
