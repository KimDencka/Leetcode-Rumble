package kim.dencka.java.medium;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
    }

    // see the visualization: https://t.me/perpriclo/3
    public static int compress(char[] chars) {
        int res = 0, i = 0;

        while (i < chars.length) {
            int streak = 1;
            chars[res++] = chars[i];

            while (i + streak < chars.length && chars[i] == chars[i + streak]) {
                streak++;
            }
            if (streak > 1) {
                for (char ch : Integer.toString(streak).toCharArray()) {
                    chars[res++] = ch;
                }
            }
            i += streak;
        }

        return res;
    }

//    public static int compress(char[] chars) {
//        if (chars.length == 1) return 1;
//
//        StringBuilder sb = new StringBuilder();
//        int counter = 1;
//        char prev = chars[0];
//
//        for (int i = 1; i < chars.length; i++) {
//            System.out.println("CHAR: " + prev);
//            if (prev == chars[i]) {
//                counter++;
//            } else {
//                System.out.printf("char: %s; counter: %d\n", prev, counter);
//                sb.append(prev);
//                if (counter > 1) sb.append(counter);
//                prev = chars[i];
//                counter = 1;
//            }
//        }
//
//        sb.append(prev);
//        if (counter > 1) sb.append(counter);
//
//        for (int i = 0; i < sb.length(); i++) {
//            chars[i] = sb.charAt(i);
//        }
//
//        return sb.length();
//    }
}
