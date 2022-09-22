package kim.dencka.java.medium.collection;

import java.util.*;

class Permutations {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        generate(nums, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private static void generate(int[] nums, ArrayList<Integer> cur, HashSet<Integer> seen) {
        if (nums.length == cur.size()) {
            result.add(new ArrayList<>(cur));
        }

        for (int num : nums) {
            if (seen.contains(num)) continue;
            cur.add(num);
            seen.add(num);
            generate(nums, cur, seen);
            seen.remove(num);
            cur.remove(cur.size() - 1);
        }
    }
}
