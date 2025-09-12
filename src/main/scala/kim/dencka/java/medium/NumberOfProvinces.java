package kim.dencka.java.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected)); // 2
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int numberOfProvince = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numberOfProvince++;
                dfs(i, isConnected, visited);
            }
        }

        return numberOfProvince;
    }

    public static void dfs(int city, int[][] isConnected, boolean[] visited) {
        visited[city] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }

    public static void bfs(int city, int[][] isConnected, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(city);
        visited[city] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[cur][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
