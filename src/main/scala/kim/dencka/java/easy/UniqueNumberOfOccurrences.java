package kim.dencka.java.easy;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {

    }

    public static boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];
        int[] unq = new int[1001];

        for (int num : arr) {
            freq[num + 1000]++;
        }

        for (int num : freq) {
            if (num > 0) {
                if (unq[num] >= 1) return false;
                unq[num]++;
            }
        }

        return true;
    }

//    Stream API
//    public static boolean uniqueOccurrences(int[] arr) {
//        Map<Integer, Long> freq = Arrays.stream(arr)
//                .boxed()
//                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//
//        return new HashSet<>(freq.values()).size() == freq.size();
//    }

//    public static boolean uniqueOccurrences(int[] arr) {
//        Map<Integer, Integer> freq = new HashMap<>();
//
//        for (int num : arr) {
//            freq.put(num, freq.getOrDefault(num, 0) + 1);
//        }
//        int[] count = new int[1000];
//        for (int num : freq.values()) {
//            if (count[num] != 0) return false;
//            count[num] = num;
//        }
//
//        return true;
//    }
}
