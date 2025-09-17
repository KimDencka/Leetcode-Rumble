package kim.dencka.java.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3, 3, 2};
        int[] nums2 = new int[]{2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k)); // 12
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0, result = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            int a = pair[1], b = pair[0];
            pq.offer(a);
            sum += a;

            if (pq.size() > k) sum -= pq.poll();
            if (pq.size() == k) result = Math.max(result, sum * (long) b);
        }
        return result;
    }
}
