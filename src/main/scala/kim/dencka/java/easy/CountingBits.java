package kim.dencka.java.easy;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1); // bitwise operation

//            if (i % 2 == 0) { // the same
//                ans[i] = ans[i / 2];
//            } else {
//                ans[i] = ans[i / 2] + 1;
//            }
        }

        return ans;
    }
}
