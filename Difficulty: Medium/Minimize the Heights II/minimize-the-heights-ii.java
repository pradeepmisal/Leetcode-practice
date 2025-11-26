

import java.util.*;

class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0; // फक्त एक tower असेल तर difference = 0

        Arrays.sort(arr);

        int ans = arr[n-1] - arr[0]; // सुरुवातीचा difference

        int smallest = arr[0] + k;
        int largest = arr[n-1] - k;

        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue; // negative height टाळा

            int minHeight = Math.min(smallest, arr[i] - k);
            int maxHeight = Math.max(largest, arr[i-1] + k);

            ans = Math.min(ans, maxHeight - minHeight);
        }

        return ans;
    }}