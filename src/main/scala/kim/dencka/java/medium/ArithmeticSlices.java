package kim.dencka.java.medium;

class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 1, 3, 4, 2, 4, 5, 10, 20, 30}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int res = 0;
        int count = 0;
        boolean valid;
        for (int i = 1; i < nums.length - 1; i++) {
            valid = (nums[i] - nums[i - 1]) == (nums[i + 1] - nums[i]);
            res += valid ? ++count : (count = 0);
        }
        return res;
    }
}
