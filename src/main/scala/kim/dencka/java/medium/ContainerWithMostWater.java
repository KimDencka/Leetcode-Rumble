package kim.dencka.java.medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height)); // 49

        int[] height2 = {1, 3, 2, 5, 25, 24, 5};
        System.out.println(maxArea(height2)); // 24
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int result = Integer.MIN_VALUE;

        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            result = Math.max(result, minHeight * (r - l));
            while (l < r && height[l] <= minHeight) l++;
            while (l < r && height[r] <= minHeight) r--;
        }

        return result;
    }
}
