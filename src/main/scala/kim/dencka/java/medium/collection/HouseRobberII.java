package kim.dencka.java.medium.collection;

class HouseRobberII {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{1000, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(run(nums, 0, nums.length - 1), run(nums, 1, nums.length));
    }

    private static int run(int[] nums, int start, int end) {
        int cnt1 = 0, cnt2 = 0;
        int curr;
        for (int i = start; i < end; i++) {
            curr = Math.max(nums[i] + cnt1, cnt2);
            cnt1 = cnt2;
            cnt2 = curr;
        }
        return cnt2;
    }
}
