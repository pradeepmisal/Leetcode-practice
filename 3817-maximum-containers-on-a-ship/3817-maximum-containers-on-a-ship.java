class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        // Calculate the total number of containers that can be placed on the desk
        int desk = n * n;  
        int ans = 0; // Variable to store the maximum number of containers that can be supported

        // Iterate from the maximum possible number of containers down to 0
        for (int i = desk; i >= 0; i--) {
            // Check if the total weight of 'desk' containers is within the maximum weight limit
            if (desk * w <= maxWeight) {
                ans = desk; // If valid, store the answer
                break; // Exit the loop as we've found the maximum possible containers
            } else {
                desk--; // If weight exceeds maxWeight, reduce the number of containers and check again
            }
        }
        
        return ans; // Return the maximum number of containers that can be supported
    }
}