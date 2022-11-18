package kim.dencka.java.easy.collection;

import java.util.*;

class NumberOfDistinctAverages {
    public static void main(String[] args) {
        System.out.println(distinctAverages(new int[]{4, 1, 4, 0, 3, 5}));
    }

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Double> hs = new HashSet<>();
        int s = 0, e = nums.length - 1;
        while (s++ < e--) hs.add((double) (nums[s] + nums[e]) / 2);
        return hs.size();
    }
}
