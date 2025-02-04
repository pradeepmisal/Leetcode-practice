class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; // Initialize maxSum with the first element
        int currentSum = nums[0]; // Initialize currentSum with the first element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i]; // Continue the ascending sequence
            } else {
                maxSum = Math.max(maxSum, currentSum); // Update maxSum
                currentSum = nums[i]; // Reset currentSum for a new subarray
            }
        }
        
        return Math.max(maxSum, currentSum); // Return the maximum found
    }
}
