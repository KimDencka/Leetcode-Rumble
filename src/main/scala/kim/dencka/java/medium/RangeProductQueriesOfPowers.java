package kim.dencka.java.medium;

import java.util.Arrays;
import java.util.Stack;

class RangeProductQueriesOfPowers {
    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1}, {2, 2}, {0, 3}};
        System.out.println(Arrays.toString(productQueries(15, input))); // [2,4,64]
    }

    public static int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        Stack<Integer> st = new Stack<>();
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) == 1) st.add((int) Math.pow(2, cnt));
            n = n >> 1;
            cnt++;
        }
        int[] arr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long res = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                res = (res * st.get(j)) % mod;
            }
            arr[i] = (int) res % mod;
        }
        return arr;
    }
}
