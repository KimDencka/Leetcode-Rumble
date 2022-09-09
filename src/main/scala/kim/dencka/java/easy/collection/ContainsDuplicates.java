package kim.dencka.java.easy.collection;

import java.util.HashMap;
import java.util.List;

class ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate(nums2));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, List.of(num));
            } else {
                return true;
            }
        }
        return false;
    }
}
