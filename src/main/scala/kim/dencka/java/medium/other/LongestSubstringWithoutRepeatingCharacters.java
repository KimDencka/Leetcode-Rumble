package kim.dencka.java.medium.other;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("sadfhlkahvljsdhaflhaosdfaasdf"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end)))
                set.add(s.charAt(end++));
            else
                set.remove(s.charAt(start++));
            max = Math.max(max, set.size());
        }
        return Math.max(max, set.size());
    }


//    public static int lengthOfLongestSubstring(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        int res = 0;
//        int cnt = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), i);
//                cnt++;
//            } else {
//                int idx = map.get(s.charAt(i));
//                map.clear();
//                map.put(s.charAt(idx + 1), idx + 1);
//                i = idx + 1;
//                res = Math.max(res, cnt);
//                cnt = 1;
//            }
//        }
//        return Math.max(res, cnt);
//    }
}
