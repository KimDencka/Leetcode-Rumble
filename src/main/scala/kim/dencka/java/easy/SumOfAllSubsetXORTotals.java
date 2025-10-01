package kim.dencka.java.easy;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        int[] nums = {5, 1, 6};
        System.out.println(subsetXORSum(nums)); // 28
    }

    public static int XORSum = 0;

    public static int subsetXORSum(int[] nums) {
        backtracking(0, new ArrayList<>(), nums);
        return XORSum;
//        return divideAndConquer(nums, 0, 0);
    }

    public static void backtracking(int start, List<Integer> combination, int[] nums) {
        int sum = 0;
        for (int num : combination) sum ^= num;
        XORSum += sum;

        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]);
            backtracking(i + 1, combination, nums);
            combination.removeLast();
        }
    }

    public static int divideAndConquer(int[] nums, int idx, int currXor) {
        if (idx == nums.length) return currXor;

        int notPick = divideAndConquer(nums, idx + 1, currXor); // skip current
        int pick = divideAndConquer(nums, idx + 1, currXor ^ nums[idx]); // take current

        return notPick + pick;
    }
}
