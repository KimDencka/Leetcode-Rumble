package kim.dencka.java.medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostToReportToTheCapital {
    public static void main(String[] args) {
        int[][] roads = {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        System.out.println(minimumFuelCost(roads, 2)); // 7
    }

    private static List<List<Integer>> graph;
    private static int seats;
    private static long fuel = 0L;

    public static long minimumFuelCost(int[][] roads, int s) {
        int n = roads.length + 1;
        seats = s;

        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : roads) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        return fuel;
    }

    private static int dfs(int cur, int parent) {
        int people = 1;

        for (int child : graph.get(cur)) {
            if (child == parent) continue;

            int childPeople = dfs(child, cur);
            long carsNeeded = (childPeople + seats - 1) / seats;
            fuel += carsNeeded;
            people += childPeople;
        }

        return people;
    }

}
