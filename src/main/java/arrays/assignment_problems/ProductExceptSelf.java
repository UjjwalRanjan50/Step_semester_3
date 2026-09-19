package arrays.assignment_problems;

public class ProductExceptSelf {

    /**
     * Computes the product of every element in the array except the element at the current index.
     * Solved in O(n) time using two passes and without division.
     *
     * @param nums The input integer array
     * @return An array where answer[i] is the product of everything except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Forward pass: compute prefix products
        // answer[i] will store the product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Backward pass: multiply with suffix products
        // rightProduct will store the product of all elements to the right of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
}
