package kim.dencka.java.medium.collection;

class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
    }

    private static int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        for (int num : nums) sum += num;

        int res1 = count(nums, 0, nums.length - 1, 1);
        int res2 = sum + count(nums, 1, nums.length - 1, -1);
        int res3 = sum + count(nums, 0, nums.length - 2, -1);

        return Math.max(res1, Math.max(res2, res3));
    }

    private static int count(int[] arr, int i, int j, int sign) {
        int cur = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            cur = Math.max(cur, 0) + arr[k] * sign;
            max = Math.max(cur, max);
        }

        return max;
    }
}
