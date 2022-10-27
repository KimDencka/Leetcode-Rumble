package kim.dencka.java.medium.other;

class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1234));
    }

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                result.append(roman[i]);
                num -= value[i];
            }
        }
        return result.toString();
    }

//    public static String intToRoman(int num) {
//        Map<Integer, String> map = new LinkedHashMap<>();
//        map.put(1000, "M");
//        map.put(900, "CM");
//        map.put(500, "D");
//        map.put(400, "CD");
//        map.put(100, "C");
//        map.put(90, "XC");
//        map.put(50, "L");
//        map.put(40, "XL");
//        map.put(10, "X");
//        map.put(9, "IX");
//        map.put(5, "V");
//        map.put(4, "IV");
//        map.put(1, "I");
//
//        StringBuilder result = new StringBuilder();
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            int cur = num / entry.getKey();
//            result.append(String.valueOf(entry.getValue()).repeat(cur));
//            num = num % entry.getKey();
//        }
//
//        return result.toString();
//    }

}
