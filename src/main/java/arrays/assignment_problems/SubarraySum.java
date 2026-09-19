package arrays.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    /**
     * Returns the total number of contiguous subarrays whose sum equals exactly k.
     * Solved in O(n) time and O(n) space using a hash map of prefix-sum frequencies.
     *
     * @param nums The input integer array (may contain negative numbers)
     * @param k The target sum
     * @return The number of contiguous subarrays summing to k
     */
    public int subarraySum(int[] nums, int k) {
        // Map to store the frequency of each prefix sum encountered so far
        Map<Integer, Integer> prefixSumFrequencies = new HashMap<>();
        
        // Base case: to handle the case where a prefix sum itself equals k
        prefixSumFrequencies.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists in the map, it means there are that many 
            // previous prefix sums that can be subtracted from currentSum to get k.
            // Hence, we found valid subarrays ending at the current position.
            int requiredPrefix = currentSum - k;
            if (prefixSumFrequencies.containsKey(requiredPrefix)) {
                count += prefixSumFrequencies.get(requiredPrefix);
            }
            
            // Add the current prefix sum to the map for future elements
            prefixSumFrequencies.put(currentSum, prefixSumFrequencies.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
