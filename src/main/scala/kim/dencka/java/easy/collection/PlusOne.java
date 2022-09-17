package kim.dencka.java.easy.collection;

import java.util.Arrays;

class PlusOne {

    // KIM_INFO SHOULD RESOLVE (JAVA)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int mem;
        if (digits[n - 1] != 9) {
            digits[n - 1] += 1;
            return digits;
        } else {
            mem = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i] += mem;
                    mem = 0;
                } else {
                    digits[i] = mem != 0 ? 0 : digits[i];
                }
            }
            if (mem == 0) {
                return digits;
            } else {
                int[] res = new int[n + 1];
                System.arraycopy(digits, 0, res, 1, n);
                res[0] = mem;
                return res;
            }
        }
    }

//    public static int[] plusOne(int[] digits) {
//        String str = "";
//        for (int n : digits) str += n;
//        char[] incrd = (new BigInteger(str).add(new BigInteger("1"))).toString().toCharArray();
//        int[] res = new int[incrd.length];
//        for (int i = 0; i < incrd.length; i++) {
//            res[i] = incrd[i] - '0';
//        }
//        return res;
//    }
}
