package kim.dencka.java.medium.collection;

import java.util.*;

class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{1, 2, 3, 15, 16, 17, 18}));
    }

    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        int old = 0, cur = 0, temp;
        for (int num : map.keySet()) {
            if (!map.containsKey(num - 1)) {
                old = cur;
                cur += map.get(num);
            } else {
                temp = Math.max(old + map.get(num), cur);
                old = cur;
                cur = temp;
            }
        }
        return cur;
    }
}
