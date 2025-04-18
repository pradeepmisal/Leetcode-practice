class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; 
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1}; // Return 1-based indices
            } else if (sum > target) {
                right--; // Decrease sum by moving right pointer left
            } else {
                left++; // Increase sum by moving left pointer right
            }
        }
        return new int[] {}; // Return empty array if no solution found
    }
}