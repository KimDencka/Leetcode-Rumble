package kim.dencka.java.medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums)); // 5
        hello:
        System.out.println("Hello");
//        System.exit(0);
    }

    public static int longestSubarray(int[] nums) {
        int l = 0, zeros = 0;
        int result = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) zeros++;
            if (zeros > 1) {
                if (nums[l] == 0) zeros--;
                l++;
            }
            result = Math.max(result, r - l);
        }
        return result;
    }
}
