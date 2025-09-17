package kim.dencka.java.hard;

class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5, 2, 7, 5};
        System.out.println(countSubarrays(input, 1, 5)); // 2
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, idx = -1;
        long cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (minK == nums[i]) minI = i;
            if (maxK == nums[i]) maxI = i;
            if (nums[i] > maxK || nums[i] < minK) idx = i;
            cnt += Math.max(Math.min(minI, maxI) - idx, 0);
        }
        return cnt;
    }
}
