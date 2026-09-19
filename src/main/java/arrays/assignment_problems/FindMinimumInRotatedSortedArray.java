package arrays.assignment_problems;

public class FindMinimumInRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array of unique elements.
     * Solved in O(log n) time using a modified binary search.
     *
     * @param nums The input integer array
     * @return The minimum element
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        // If the array is not rotated (or rotated n times), it's already sorted
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If the middle element is greater than the rightmost element,
            // the minimum must be to the right of mid, because the array 
            // drops off somewhere in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, the middle element is less than or equal to the rightmost element.
            // This means the right half is properly sorted, so the minimum is at mid
            // or somewhere in the left half.
            else {
                right = mid;
            }
        }
        
        return nums[left];
    }
}
