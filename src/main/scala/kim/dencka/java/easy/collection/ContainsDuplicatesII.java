package kim.dencka.java.easy.collection;

import java.util.HashMap;

public class ContainsDuplicatesII {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 0, 1, 1};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};

        System.out.println(containsNearbyDuplicate(nums1, 2));
        System.out.println(containsNearbyDuplicate(nums2, 1));
        System.out.println(containsNearbyDuplicate(nums3, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
