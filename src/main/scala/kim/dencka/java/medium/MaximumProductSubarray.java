package kim.dencka.java.medium;

class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        int maxCur, minCur;
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(nums[i], nums[i] * max);
            minCur = Math.min(nums[i], nums[i] * min);
            maxCur = Math.max(maxCur, nums[i] * min);
            minCur = Math.min(minCur, nums[i] * max);
            max = maxCur;
            min = minCur;

            res = Math.max(res, max);
        }
        return res;
    }
}
