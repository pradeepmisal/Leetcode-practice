class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> set = new ArrayList<>();
       
        for(int i = 0; i < m ; i++){
            set.add(nums1[i]);
        }
        for(int j=0; j < n; j++){
            set.add(nums2[j]);
        }
       
        Collections.sort(set);
        //basically here only copying nubers in nums1
        for(int i = 0; i < set.size(); i++){
            nums1[i] = set.get(i);
        }
    }
}