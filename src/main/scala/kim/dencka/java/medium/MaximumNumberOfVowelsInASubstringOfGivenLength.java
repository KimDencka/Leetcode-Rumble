package kim.dencka.java.medium;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k)); // 3
    }

    public static int maxVowels(String s, int k) {
        int[] bits = new int[128];
        bits['a']++;
        bits['e']++;
        bits['i']++;
        bits['o']++;
        bits['u']++;

        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += bits[chars[i]];
        }

        int maxSum = sum;
        for (int i = k; i < chars.length; i++) {
            sum += (bits[chars[i]] - bits[chars[i - k]]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

//    public static int maxVowels(String s, int k) {
//        String vowels = "aeiouAEIOU";
//        int[] bits = new int[s.length()];
//        char[] chars = s.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//            if (vowels.indexOf(chars[i]) != -1) bits[i] = 1;
//        }
//
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += bits[i];
//        }
//
//        int maxSum = sum;
//        for (int i = k; i < bits.length; i++) {
//            sum += bits[i] - bits[i - k];
//            maxSum = Math.max(maxSum, sum);
//        }
//
//        return maxSum;
//    }
}
