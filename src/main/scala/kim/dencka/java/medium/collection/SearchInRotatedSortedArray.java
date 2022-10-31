package kim.dencka.java.medium.collection;

class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] input = {7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6};
//        int[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(search(input, 5));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target <= nums[high] && target > nums[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
