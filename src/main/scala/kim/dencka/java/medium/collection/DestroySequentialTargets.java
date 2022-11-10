package kim.dencka.java.medium.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class DestroySequentialTargets {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 6};
        System.out.println(destroyTargets(nums, 2));
    }

    public static int destroyTargets(int[] nums, int space) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            num = num % space;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = Collections.max(map.values());
        Arrays.sort(nums);
        for (int num : nums) {
            if (map.get(num % space) == max) return num;
        }
        return 0;
    }
}