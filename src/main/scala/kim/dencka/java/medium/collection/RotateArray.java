package kim.dencka.java.medium.collection;

import java.util.Arrays;

class RotateArray {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        rotate(input, 3);
        System.out.println(Arrays.toString(input));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] arr, int l, int r) {
        int temp;
        while (l < r) {
            temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
