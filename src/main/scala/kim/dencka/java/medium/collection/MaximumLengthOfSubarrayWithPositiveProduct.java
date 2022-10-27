package kim.dencka.java.medium.collection;

class MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{1, 2, 3, 5, -6, 4, -6, 0, 10}));
    }

    public static int getMaxLen(int[] nums) {
        int res = 0;
        int cntP = 0;
        int cntN = 0;
        int temp;
        for (int num : nums) {
            if (num > 0) {
                cntP++;
                cntN = cntN == 0 ? 0 : cntN + 1;
            } else if (num < 0) {
                temp = cntP;
                cntP = cntN == 0 ? 0 : cntN + 1;
                cntN = temp + 1;
            } else {
                cntP = 0;
                cntN = 0;
            }
            res = Math.max(res, cntP);
        }
        return res;
    }
}
