package kim.dencka.java.medium;

import java.util.*;

class TotalCostToHireKWorkers {
    public static void main(String[] args) {
        int[] input = new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8};
        System.out.println(totalCost(input, 3, 4)); // 11
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        int r = costs.length - 1, l = 0;
        long sum = 0;
        PriorityQueue<Integer> pql = new PriorityQueue<>();
        PriorityQueue<Integer> pqr = new PriorityQueue<>();


        while (k > 0) {
            while (pql.size() < candidates && l <= r) pql.add(costs[l++]);
            while (pqr.size() < candidates && l <= r) pqr.add(costs[r--]);
            int l_min = pql.size() > 0 ? pql.peek() : Integer.MAX_VALUE;
            int r_min = pqr.size() > 0 ? pqr.peek() : Integer.MAX_VALUE;
            k--;
            if (l_min <= r_min) {
                sum += l_min;
                pql.poll();
            } else {
                sum += r_min;
                pqr.poll();
            }

        }
        return sum;
    }
}
