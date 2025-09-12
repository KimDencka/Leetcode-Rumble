package kim.dencka.java.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> list1 = List.of(List.of(1), List.of(2), List.of(3), List.of());
        List<List<Integer>> list2 = List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0));
        List<List<Integer>> list3 = List.of(List.of(1, 3), List.of(1, 4), List.of(2, 3, 4, 1), List.of(), List.of(4, 3, 2));
        List<List<Integer>> list4 = List.of(List.of(1), List.of(2), List.of(2), List.of());

        System.out.println(canVisitAllRooms(list1)); // true
        System.out.println(canVisitAllRooms(list2)); // false
        System.out.println(canVisitAllRooms(list3)); // true
        System.out.println(canVisitAllRooms(list4)); // false
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, rooms, visited);

        for (boolean isVisited : visited) {
            if (!isVisited) return false;
        }

        return true;
    }

    public static void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;

        for (int neighbour : rooms.get(room)) {
            if (!visited[neighbour]) {
                dfs(neighbour, rooms, visited);
            }
        }
    }
}
