package kim.dencka.java.medium;

import java.util.*;

class CombinationSumII {
    public static void main(String[] args) {
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(input, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        generate(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public static void generate(int idx, int[] nums, int remain, List<Integer> cur, List<List<Integer>> result) {
        if (remain < 0) return;
        if (remain == 0) {
            result.add(new ArrayList<>(cur));
        } else {
            for (int i = idx; i < nums.length; i++) {
                if (i > idx && nums[i] == nums[i - 1]) continue;
                cur.add(nums[i]);
                generate(i + 1, nums, remain - nums[i], cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
