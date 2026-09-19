package arrays.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Finds all unique triplets in the array that sum to zero.
     * Solved in O(n^2) time using sorting and two pointers.
     *
     * @param nums The input integer array
     * @return A 2D array containing the unique triplets
     */
    public int[][] threeSum(int[] nums) {
        List<int[]> resultsList = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    resultsList.add(new int[]{nums[i], nums[left], nums[right]});
                    
                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        // Convert List of int arrays back to int[][] to match required signature
        int[][] result = new int[resultsList.size()][3];
        for (int i = 0; i < resultsList.size(); i++) {
            result[i] = resultsList.get(i);
        }
        
        return result;
    }
}
