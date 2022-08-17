package kim.dencka.java.easy.collection;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int[] nums2 = {2, 2, 1};
        int[] nums3 = {-3, -3, -2, -2, -1, 0, 0, 1, 1, 2, 2, 3, 3};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber(nums2));
        System.out.println(singleNumber(nums3));
    }

    public static int singleNumber(int[] nums) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) xor ^= nums[i];
        return xor;
    }
}
