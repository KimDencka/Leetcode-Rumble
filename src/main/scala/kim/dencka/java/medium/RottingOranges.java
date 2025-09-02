package kim.dencka.java.medium;

import java.util.*;

class RottingOranges {
    public static void main(String[] args) {
        int[][] input = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(input));
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] seen = new boolean[n][m];
        Queue<Orange> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Orange(i, j, 0));
                    seen[i][j] = true;
                }
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        int cnt = 0, time = 0;
        int x, y;

        while (!q.isEmpty()) {
            Orange or = q.poll();
            time = Math.max(time, or.ti);
            for (int i = 0; i < 4; i++) {
                x = or.i + row[i];
                y = or.j + col[i];
                if (x >= 0 && y >= 0 && x < n && y < m && !seen[x][y] && grid[x][y] == 1) {
                    q.offer(new Orange(x, y, or.ti + 1));
                    grid[x][y] = 2;
                    seen[x][y] = true;
                    cnt++;
                }
            }
        }
        if (fresh != cnt) return -1;
        return time;
    }

}

class Orange {
    int i, j, ti;

    public Orange(int i, int j, int ti) {
        this.i = i;
        this.j = j;
        this.ti = ti;
    }
}
