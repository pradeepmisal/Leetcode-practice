class Solution {

    public boolean canMakeSubsequence(String str1, String str2) {

        // Lengths of the input strings
        int len1 = str1.length();
        int len2 = str2.length();

        // If str2 is longer than str1, it cannot be a subsequence
        if (len2 > len1) return false;

        // Initialize pointers for str1 and str2
        int p1 = 0, p2 = 0;

        // Traverse str1 to match characters in str2
        while (p1 < len1 && p2 < len2) {
            char ch1 = str1.charAt(p1); // Current character in str1
            char ch2 = str2.charAt(p2); // Current character in str2

            // Check if characters match directly or via cyclic increment
            if (ch1 == ch2 || (ch1 == 'z' && ch2 == 'a') || ch1 + 1 == ch2) {
                p2++; // Move pointer for str2 if match found
            }
            p1++; // Always move pointer for str1
        }

        // If all characters in str2 are matched, return true
        return p2 == len2;
    }
}