package kim.dencka.java.easy;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 0, 1, 1, 0};
        System.out.println(pivotIndex(nums)); // 5
    }

    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }

//    public static int pivotIndex(int[] nums) {
//        int sum = 0, n = nums.length;
//        for (int i = 1; i < n; i++) sum += nums[i];
//        int leftSum = 0, rightSum = sum;
//
//        for (int i = 0; i < n; i++) {
//            if (leftSum == rightSum) return i;
//            leftSum += nums[i];
//            if (i + 1 == n) {
//                rightSum = 0;
//            } else {
//                rightSum -= nums[i + 1];
//            }
//        }
//
//        return -1;
//    }
}
