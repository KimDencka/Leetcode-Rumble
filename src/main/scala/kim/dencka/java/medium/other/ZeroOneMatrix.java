package kim.dencka.java.medium.other;

import java.util.*;

class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(input)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] seen = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    seen[i][j] = true;
                }
            }
        }

        int[] row = {-1, 0, +1, 0};
        int[] col = {0, +1, 0, -1};
        while (!q.isEmpty()) {
            Pair p = q.poll();
            res[p.i][p.j] = p.dist;
            for (int i = 0; i < 4; i++) {
                int x = p.i + row[i];
                int y = p.j + col[i];
                if (x >= 0 && y >= 0 && x < n && y < m && !seen[x][y]) {
                    q.add(new Pair(x, y, p.dist + 1));
                    seen[x][y] = true;
                }
            }
        }
        return res;
    }

    static class Pair {
        int i;
        int j;
        int dist;

        public Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }


}
