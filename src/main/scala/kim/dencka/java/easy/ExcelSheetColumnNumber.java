package kim.dencka.java.easy;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY")); // 701
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (char ch : columnTitle.toCharArray()) {
            result = result * 26 + (ch - 'A' + 1);
        }

        return result;
    }
}
