package kim.dencka.java.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        List<String> combinations = new ArrayList<>();
        helper("", digits, map, combinations);

        return combinations;
    }

    public static void helper(String combination, String digits, Map<Character, List<Character>> map, List<String> combinations) {
        if (digits.isEmpty()) {
            combinations.add(combination);
        } else {
            List<Character> letters = map.get(digits.charAt(0));
            for (Character ch : letters) {
                helper(combination + ch, digits.substring(1), map, combinations);
            }
        }
    }
}
