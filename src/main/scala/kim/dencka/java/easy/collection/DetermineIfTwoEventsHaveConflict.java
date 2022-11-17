package kim.dencka.java.easy.collection;

import java.util.Arrays;

public class DetermineIfTwoEventsHaveConflict {
    public static void main(String[] args) {
        String[] event1 = {"06:20","06:28"};
        String[] event2 = {"04:01","06:44"};
        System.out.println(haveConflict(event1, event2));
    }

    public static boolean haveConflict(String[] event1, String[] event2) {
        int[] inter1 = toMin(event1);
        int[] inter2 = toMin(event2);
        System.out.println(Arrays.toString(inter1));
        System.out.println(Arrays.toString(inter2));
        for (int i = 0; i < 2; i++) {
            if (inter1[i] >= inter2[0] && inter1[i] <= inter2[1]) return true;
            if (inter2[i] >= inter1[0] && inter2[i] <= inter1[1]) return true;
        }
        return false;
    }

    private static int[] toMin(String[] str) {
        int[] result = {-1, -1};
        for (int i = 0; i < 2; i++) {
            String[] time = str[i].split(":");
            int h = Integer.parseInt(time[0]);
            result[i] = h * 60 + Integer.parseInt(time[1]);
        }
        return result;
    }
}
