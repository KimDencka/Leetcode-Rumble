package kim.dencka.java.easy;

class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber(nums2));
    }

    public static int missingNumber(int[] nums) {
        int k = nums.length;
        int full = k * (k + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return full - sum;
    }
}
