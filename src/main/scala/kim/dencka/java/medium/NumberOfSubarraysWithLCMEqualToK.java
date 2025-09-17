package kim.dencka.java.medium;

class NumberOfSubarraysWithLCMEqualToK {
    public static void main(String[] args) {
        int[] input = new int[]{3, 6, 2, 7, 1};
        System.out.println(subarrayLCM(input, 6)); // 4
    }

    public static int subarrayLCM(int[] nums, int k) {
        int res = 0;
        long p;
        for (int i = 0; i < nums.length; i++) {
            p = 1;
            for (int j = i; j < nums.length; j++) {
                p = (p * nums[j]) / lcm(p, nums[j]);
                if (p == k) res++;
            }
        }
        return res;
    }

    public static long lcm(long a, long b) {
        if (b == 0) return a;
        return lcm(b, a % b);
    }
}
