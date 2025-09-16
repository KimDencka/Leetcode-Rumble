package kim.dencka.java.medium;

import java.util.*;

class RottingOranges {
    public static void main(String[] args) {
        int[][] input = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(input));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> rotten = new ArrayDeque<>();
        int freshCount = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) rotten.offer(new int[]{r, c});
                if (grid[r][c] == 1) freshCount++;
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};

        int infected = 0, time = 0;
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            boolean isInfected = false;
            for (int i = 0; i < size; i++) {
                int[] pos = rotten.poll();
                for (int j = 0; j < 4; j++) {
                    int r = pos[0] + row[j];
                    int c = pos[1] + col[j];

                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        rotten.offer(new int[]{r, c});
                        infected++;
                        isInfected = true;
                    }
                }
            }
            if (isInfected) time++;
        }

        if (freshCount != infected) return -1;
        return time;
    }
}
