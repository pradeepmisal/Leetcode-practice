import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency using array
        int[] freq = new int[128]; // ASCII range
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        // Step 2: Convert string to Character array for sorting
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        // Step 3: Sort characters by frequency (descending)
        Arrays.sort(chars, (a, b) -> {
            if (freq[b] != freq[a]) {
                return freq[b] - freq[a];
            } else {
                return a - b; // Optional: sort by ASCII if frequencies are equal
            }
        });

        // Step 4: Build result string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            result.append(c);
        }

        return result.toString();
    }
}
