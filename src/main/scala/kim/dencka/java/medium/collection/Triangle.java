package kim.dencka.java.medium.collection;

import java.util.*;

class Triangle {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        ));
        System.out.println(minimumTotal(input));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> curr;
        int min;
        for (int i = triangle.size() - 2; i >= 0; i--) {
            curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + curr.get(j);
                curr.set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }
}
