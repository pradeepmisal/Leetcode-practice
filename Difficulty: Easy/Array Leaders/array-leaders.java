
class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length; // Using array length to get the size of the array

        int maxEle = arr[n - 1]; // Initialize with the last element

        // We start traversing the array from the last element.
        for (int i = n - 1; i >= 0; i--) {
            // Comparing the current element with the maximum element stored.
            if (arr[i] >= maxEle) {
                maxEle = arr[i]; // Updating the maximum element.
                res.add(maxEle); // Storing the current element in the result list.
            }
        }

        // Reversing the list to return the leaders in the correct order.
        Collections.reverse(res);
        return res; // Returning the result list.
    }
}
