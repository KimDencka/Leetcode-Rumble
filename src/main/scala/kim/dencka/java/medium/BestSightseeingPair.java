package kim.dencka.java.medium;

class BestSightseeingPair {
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int iMax = values[0];
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res, iMax + values[i] - i);
            iMax = Math.max(iMax, values[i] + i);
        }
        return res;
    }
}
