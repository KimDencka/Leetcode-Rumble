package kim.dencka.java.medium;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k)); // 6
    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0, zeros = 0;
        int result = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;
            if (zeros > k) {
                if (nums[l] == 0) zeros--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
