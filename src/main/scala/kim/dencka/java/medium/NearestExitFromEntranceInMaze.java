package kim.dencka.java.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        char[][] maze = new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'},};
        System.out.println(nearestExit(maze, new int[]{1, 2})); // 1
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int rLen = maze.length, cLen = maze[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];

                if ((r != entrance[0] || c != entrance[1]) && (r == 0 || c == 0 || r == rLen - 1 || c == cLen - 1)) {
                    return steps;
                }

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < rLen && nc >= 0 && nc < cLen && maze[nr][nc] == '.') {
                        maze[nr][nc] = '+';
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
