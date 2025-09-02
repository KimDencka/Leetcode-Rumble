package kim.dencka.java.medium;

import java.util.*;

class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        generate(1, n, k, new ArrayList<>(), combs);
        return combs;
    }

    private static void generate(int s, int n, int k, List<Integer> cur, List<List<Integer>> combs) {
        if (cur.size() == k) combs.add(new ArrayList<>(cur));

        for (int i = s; i <= n; i++) {
            cur.add(i);
            generate(i + 1, n, k, cur, combs);
            cur.remove(cur.size() - 1);
        }
    }
}
