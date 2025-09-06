package kim.dencka.java.medium;

public class RemovingStarsFromAString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {
        char[] target = s.toCharArray();
        char[] chars = new char[target.length];

        int j = 0;
        for (char ch : target) {
            if (ch == '*') {
                j--;
                continue;
            }
            chars[j++] = ch;
        }

        return new String(chars, 0, j);
    }

//    public static String removeStars(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        char[] chars = s.toCharArray();
//        int i = chars.length - 1, starCount = 0;
//        while (i >= 0) {
//            if (chars[i] == '*') {
//                starCount++;
//            } else if (chars[i] != '*' && starCount == 0) {
//                stack.push(chars[i]);
//            } else {
//                while (i >= 0 && starCount > 0 && chars[i] != '*') {
//                    starCount--;
//                    i--;
//                }
//                continue;
//            }
//            i--;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) sb.append(stack.pop());
//
//        return sb.toString();
//    }
}
