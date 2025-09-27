package kim.dencka.java.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7)); // 1,2,4
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(1, new ArrayList<>(), k, n, combinations);

        return combinations;
    }

    public static void backtracking(int start, List<Integer> combination, int k, int n, List<List<Integer>> combinations) {
        if (combination.size() == k && n == 0) {
            combinations.add(new ArrayList<>(combination));
        } else {
            for (int i = start; i <= 9; i++) {
                if (i > n) break;
                combination.add(i);
                backtracking(i + 1, combination, k, n - i, combinations);
                combination.removeLast();
            }
        }
    }
}
