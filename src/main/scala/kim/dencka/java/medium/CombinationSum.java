package kim.dencka.java.medium;

import java.util.*;

class CombinationSum {
    public static void main(String[] args) {
        int[] input = {2, 3, 6, 7};
        System.out.println(combinationSum(input, 7));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generate(0, nums, target, new ArrayList<>(), result);
        return result;
    }

    private static void generate(int idx, int[] nums, int remain, List<Integer> cur, List<List<Integer>> result) {
        if (remain < 0) return;
        if (remain == 0) result.add(new ArrayList<>(cur));
        else {
            for (int i = idx; i < nums.length; i++) {
                cur.add(nums[i]);
                generate(i, nums, remain - nums[i], cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
