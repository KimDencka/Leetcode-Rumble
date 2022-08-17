package kim.dencka.java.easy.collection;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // cheating
//        nums[nums.length / 2]
        for (int num : nums) {
            int result = 0;
            for (int n : nums) {
                if (n == num) result++;
            }
            if (result > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
