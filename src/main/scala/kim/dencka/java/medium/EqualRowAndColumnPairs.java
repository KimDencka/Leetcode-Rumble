package kim.dencka.java.medium;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(equalPairs(grid)); // 1
    }

    public static int equalPairs(int[][] grid) {
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            int key = rowHashCode(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < grid.length; i++) {
            int colHashCode = colHashCode(grid, i);
            counter += map.getOrDefault(colHashCode, 0);
        }
        return counter;
    }

    public static int rowHashCode(int[] row) {
        int result = 0;
        for (int col : row) {
            result = col + (result * 8);
        }
        return result;
    }

    public static int colHashCode(int[][] grid, int col) {
        int result = 0;
        for (int[] row : grid) {
            result = row[col] + (result * 8);
        }
        return result;
    }


//    public static int equalPairs(int[][] grid) {
//        int n = grid.length;
//        Map<String, Integer> map = new HashMap<>();
//
//        StringBuilder streak = new StringBuilder();
//        for (int[] row : grid) {
//            for (int c = 0; c < n; c++) {
//                streak.append(row[c]).append(' ');
//            }
//            String key = streak.toString();
//            map.put(key, map.getOrDefault(key, 0) + 1);
//            streak.setLength(0);
//        }
//
//        int result = 0;
//        for (int c = 0; c < n; c++) {
//            for (int[] row : grid) {
//                streak.append(row[c]).append(' ');
//            }
//            result += map.getOrDefault(streak.toString(), 0);
//            streak.setLength(0);
//        }
//
//        return result;
//    }
}
