package kim.dencka.java.easy;

import java.util.Arrays;

class FloodFill {
    public static void main(String[] args) {
        int[][] input = {{1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 1, 1}};
        System.out.println(Arrays.deepToString(floodFill(input, 1, 1, 2)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int cur = image[sr][sc];
        if (color != cur) dfs(image, sr, sc, cur, color);
        return image;
    }

    public static void dfs(int[][] image, int r, int c, int cur, int color) {
        if (image[r][c] == cur) {
            image[r][c] = color;
            if (r >= 1) dfs(image, r - 1, c, cur, color);
            if (c >= 1) dfs(image, r, c - 1, cur, color);
            if (r + 1 < image.length) dfs(image, r + 1, c, cur, color);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, cur, color);
        }
    }
}
