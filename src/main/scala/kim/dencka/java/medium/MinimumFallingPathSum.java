package kim.dencka.java.medium;

import java.util.Arrays;

class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] input = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(input));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int[] cur;
        int min = Integer.MAX_VALUE;
        for (int i = matrix.length - 2; i >= 0; i--) {
            cur = matrix[i];
            for (int j = 0; j < cur.length; j++) {
                if (j == 0) {
                    cur[j] = cur[j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == cur.length - 1) {
                    cur[j] = cur[j] + Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]);
                } else {
                    cur[j] = cur[j] + Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j + 1], matrix[i + 1][j]));
                }
                System.out.println(Arrays.deepToString(matrix));
            }
        }
        for (int num : matrix[0]) min = Math.min(num, min);
        return min;
    }
}
