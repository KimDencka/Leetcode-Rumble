package kim.dencka.java.medium;

import java.util.*;

class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generate(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void generate(int s, int[] nums, List<Integer> cur, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(cur));

        for (int i = s; i < nums.length; i++) {
            cur.add(nums[i]);
            generate(i + 1, nums, cur, subsets);
            cur.remove(cur.size() - 1);
        }
    }


}
