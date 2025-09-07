package kim.dencka.java.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate {
    public static void main(String[] args) {
        String s = "RRDDD";
        System.out.println(predictPartyVictory(s));
    }

    public static String predictPartyVictory(String senate) {
        Deque<Integer> rads = new ArrayDeque<>();
        Deque<Integer> dirs = new ArrayDeque<>();
        int n = senate.length();
        char[] chars = senate.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chars[i] == 'R') {
                rads.offer(i);
            } else {
                dirs.offer(i);
            }
        }

        while (!rads.isEmpty() && !dirs.isEmpty()) {
            int r = rads.poll(), d = dirs.poll();
            if (d < r) {
                dirs.offer(d + n++);
            } else {
                rads.offer(r + n++);
            }
        }

        return rads.isEmpty() ? "Dire" : "Radiant";
    }

    // bombastic; 1 ms; beats 100%
//    public String predictPartyVictory(String senate) {
//        return electionResult(senate.toCharArray(), senate.length(), 0);
//    }
//
//    private String electionResult(char[] partyMembers, int length, int count) {
//        int index = 0;
//        for (int i = 0; i < length; i++) {
//            if (partyMembers[i] == 'R') {
//                if (count >= 0) {
//                    partyMembers[index++] = 'R';
//                }
//                count++;
//            } else {
//                if (count <= 0) {
//                    partyMembers[index++] = 'D';
//                }
//                count--;
//            }
//        }
//        if (Math.abs(count) >= index) {
//            return (count > 0) ? "Radiant" : "Dire";
//        }
//        return electionResult(partyMembers, index, count);
//    }
}
