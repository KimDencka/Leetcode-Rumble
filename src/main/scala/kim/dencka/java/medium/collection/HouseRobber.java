package kim.dencka.java.medium.collection;

class HouseRobber {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(rob(new int[]{0, 1, 2, 0, 0, 3, 0, 0, 0, 1}));
    }

    public static int rob(int[] nums) {
        int res = nums[0];
        int old = 0, cur;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] + old;
            old = res;
            res = Math.max(cur, res);
        }
        return res;
    }
}
