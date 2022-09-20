package kim.dencka.java.easy.collection;

class ReverseString {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l', 'l', 'o' };
        reverseString(input);
        System.out.println(input);

    }

    public static void reverseString(char[] s) {
        char temp;
        int i = 0, j = s.length - 1;
        while (i < j) {
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
