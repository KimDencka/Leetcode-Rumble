package kim.dencka.java.medium;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        int[][] connections = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(6, connections)); // 3
    }

    static int count = 0;

    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] conn : connections) {
            adj.computeIfAbsent(conn[0], k -> new ArrayList<>()).add(List.of(conn[1], 1));
            adj.computeIfAbsent(conn[1], k -> new ArrayList<>()).add(List.of(conn[0], 0));
        }
        dfs(0, -1, adj);
        return count;
    }

    public static void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if (!adj.containsKey(node)) return;

        for (List<Integer> nei : adj.get(node)) {
            int neighbour = nei.get(0);
            int sign = nei.get(1);
            if (neighbour != parent) {
                count += sign;
                dfs(neighbour, node, adj);
            }
        }
    }
}
