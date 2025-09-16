package kim.dencka.java.medium;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        System.out.println(Arrays.toString(calcEquation(equations, values, queries))); // [6.0, 0.5, -1.0, 1.0, -1.0]
    }

    /**
     * Calculates the result of division queries based on given equations.
     * <p>
     * Idea: build a graph where nodes are variables and edges represent division ratios.
     * For each query, perform DFS to find a path from src to dest, multiplying edge weights.
     * If no path exists, return -1.0.
     *
     * @param equations list of equations, each equation is a pair [a, b] meaning a / b = value
     * @param values    array of division results corresponding to each equation
     * @param queries   list of queries, each query is a pair [src, dest]
     * @return array of results for each query
     */
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            result[i] = dfs(src, dest, graph, visited);
        }

        return result;
    }

    /**
     * Builds a bidirectional weighted graph from equations.
     * Each equation a / b = val creates edges:
     * - a -> b with weight = val
     * - b -> a with weight = 1/val
     *
     * @param equations list of equations
     * @param values    array of division results
     * @return graph represented as adjacency map
     */
    public static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        return graph;
    }

    /**
     * Depth-first search to evaluate division from src to dest.
     * Traverses neighbors recursively, multiplying weights along the path.
     * <p>
     * Termination cases:
     * - If src is not in the graph, return -1.0
     * - If direct edge src -> dest exists, return its value
     * - Otherwise, explore neighbors until a path is found or all options are exhausted
     *
     * @param src     starting variable
     * @param dest    target variable
     * @param graph   adjacency map representing the equations
     * @param visited set of already visited nodes to prevent cycles
     * @return computed division result, or -1.0 if no path exists
     */
    public static double dfs(String src, String dest, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(src)) return -1.0;

        if (graph.get(src).containsKey(dest)) return graph.get(src).get(dest);

        visited.add(src);

        for (Map.Entry<String, Double> neighbour : graph.get(src).entrySet()) {
            String next = neighbour.getKey();
            double val = neighbour.getValue();

            if (!visited.contains(next)) {
                double product = dfs(next, dest, graph, visited);
                if (product != -1) {
                    return val * product;
                }
            }
        }

        return -1;
    }

}
