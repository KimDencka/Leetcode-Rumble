package kim.dencka.java.medium;

import java.util.Arrays;

class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String[] chunks = new String[numRows];
        Arrays.fill(chunks, "");
        boolean switcher = true;
        int i = 0;
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (switcher) {
                chunks[i++] += ch;
                if (i == numRows - 1) switcher = false;
            } else {
                chunks[i--] += ch;
                if (i == 0) switcher = true;
            }
        }

        for (String str : chunks) res.append(str);
        return res.toString();
    }
}
