class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for(int i: nums1){
            set1.add(i);
        }
        for(int j: nums2){
            if(set1.contains(j)){
                result.add(j);
            }
        }
        //convert result set to array
       int[] arr = new int[result.size()];
       int idx=0;
       for(int s : result){
        arr[idx++] = s;
       }
       return arr;
    }
}