package kim.dencka.java.easy.collection;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {

    // KIM_INFO SHOULD RESOLVE (JAVA)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        String str = "";
        for (int n : digits) str += n;
        char[] incrd = (new BigInteger(str).add(new BigInteger("1"))).toString().toCharArray();
        int[] res = new int[incrd.length];
        for (int i = 0; i < incrd.length; i++) {
            res[i] = incrd[i] - '0';
        }
        return res;
    }
}
