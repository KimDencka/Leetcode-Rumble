package kim.dencka.java.medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2)); // 5
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }

        return heap.peek();
    }

//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }
}
