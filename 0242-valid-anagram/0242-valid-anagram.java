class Solution {
    public boolean isAnagram(String s, String t) {
        //convert both the string into array 
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        //sorting 
        Arrays.sort(arr1);
        Arrays.sort(arr2);
         return Arrays.equals(arr1, arr2);
    }
}