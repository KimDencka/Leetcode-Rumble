package kim.dencka.java.medium.collection;

import java.util.Arrays;

class NextPermutation {
    public static void main(String[] args) {
        int[] input = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        // expected: 1, 5, 8, 5, 1, 3, 4, 6, 7
        nextPermutation(input);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(i, j, nums);
        }
        reverse(i + 1, nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int i, int[] array) {
        int j = array.length - 1;
        while (i < j) {
            swap(i, j, array);
            i++;
            j--;
        }
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
