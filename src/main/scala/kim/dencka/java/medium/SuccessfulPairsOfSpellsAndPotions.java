package kim.dencka.java.medium;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        System.out.println(Arrays.toString(successfulPairs(spells, potions, 16))); // [2, 0, 2]
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int l = 0, h = potions.length - 1;
            int spell = spells[i];
            while (l <= h) {
                int mid = (l + h) / 2;
                if ((long) spell * potions[mid] >= success) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            result[i] = potions.length - l;
        }

        return result;
    }

}
