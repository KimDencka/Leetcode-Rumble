package kim.dencka.java.medium;

class NumberOfSubarraysWithGCDEqualToK {
    public static void main(String[] args) {
        int[] input = new int[]{9, 3, 1, 2, 6, 3};
        System.out.println(subarrayGCD(input, 3)); // 4
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int currGcd = nums[i];
            if (currGcd == k) ans++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < k) break;
                currGcd = gcd(nums[j], currGcd);
                if (currGcd == k) ans++;
            }
        }
        return ans;
    }
}
