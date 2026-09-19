package arrays.assignment_problems;

public class MaximumSubarray {

    /**
     * Finds the contiguous subarray with the largest sum.
     * Solved using Kadane's algorithm in O(n) time and O(1) space.
     *
     * @param nums The input integer array (may contain negative numbers)
     * @return The maximum sum of any contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must contain at least one element");
        }
        
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current running subarray 
            // or abandon it and start fresh from the current element.
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum sum if the current running sum is larger.
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
