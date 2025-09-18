package kim.dencka.java.medium;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int[] piles2 = {30, 11, 23, 4, 20};
        int[] piles3 = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles, 8)); // 4
        System.out.println(minEatingSpeed(piles2, 5)); // 30
        System.out.println(minEatingSpeed(piles3, 6)); // 23
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000000000;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (canEatInTime(piles, mid, h)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean canEatInTime(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile / k);
            if (pile % k != 0) hours++;
        }
        return hours <= h;
    }
}
