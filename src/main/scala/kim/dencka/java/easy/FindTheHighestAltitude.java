package kim.dencka.java.easy;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int maxHigh = 0, currentHigh = 0;
        for (int num : gain) {
            currentHigh += num;
            maxHigh = Math.max(maxHigh, currentHigh);
        }
        return maxHigh;
    }
}
