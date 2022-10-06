package kim.dencka.java.hard.collection;

class TrappingRainWater {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        int res = 0;

        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        for (int i = 0; i < n; i++) res += Math.min(leftMax[i], rightMax[i]) - height[i];

        return res;
    }
}
