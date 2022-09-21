package kim.dencka.java.medium.other;

import java.util.HashMap;

class PermutationInString {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "ab"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> frame = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            window.put(s1.charAt(i), window.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            frame.put(s2.charAt(i), frame.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (frame.equals(window)) return true;

        int j = 0;
        char prev = s2.charAt(j);
        for (int i = s1.length(); i < s2.length(); i++) {
            if (!frame.equals(window)) {
                if (frame.get(prev) == 1) {
                    frame.remove(prev);
                } else {
                    frame.put(prev, frame.get(prev) - 1);
                }
                frame.put(s2.charAt(i), frame.getOrDefault(s2.charAt(i), 0) + 1);
                prev = s2.charAt(++j);
            }
            if (frame.equals(window)) return true;
        }
        return false;
    }
}
