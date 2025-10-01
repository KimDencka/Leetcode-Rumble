package kim.dencka.java.easy;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701)); // ZY
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char ch = (char) ((columnNumber % 26) + 'A');
            sb.append(ch);

            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
