package kim.dencka.java.medium.collection;

class JumpGameII {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int max_steps = 0;
        int cur = 0;

        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            max_steps = Math.max(max_steps, i + nums[i]);
            if (cur == i) {
                cur = max_steps;
                jumps++;
            }
            if (cur > n - 1) return jumps;
        }

        return jumps;
    }
}
