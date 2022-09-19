package kim.dencka.java.easy.collection;

class BinarySearch {
    public static void main(String[] args) {
        int[] input = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(input, 9));
        System.out.println(search(input, 2));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}