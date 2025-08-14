class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); // 1123
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }

    return false;
    }
}