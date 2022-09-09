package kim.dencka.java.easy.collection;

class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        // cheating
//        nums[nums.length / 2]
        int cnt = 0;
        int maj = 0;

        for (int num : nums) {
            if (cnt == 0) maj = num;

            if (maj != num) cnt--;
            else cnt++;
        }
        return maj;
    }
}
