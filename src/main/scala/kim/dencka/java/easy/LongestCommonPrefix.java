package kim.dencka.java.easy;

class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        String cur = strs[0];
        boolean check = true;
        for (int i = 0; i < cur.length(); i++) {
            for (String str : strs) {
                try {
                    check = check && (str.charAt(i) == cur.charAt(i));
                } catch (Exception e) {
                    check = false;
                    break;
                }
            }
            if (!check) break;
            res.append(cur.charAt(i));
        }
        return res.toString();
    }
}
