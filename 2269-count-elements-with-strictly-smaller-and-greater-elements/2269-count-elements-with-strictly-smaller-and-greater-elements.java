class Solution {
    public int countElements(int[] nums) {
        //sort
        int n= nums.length;
        Arrays.sort(nums); // 2, 7 , 11 ,15
        int min = nums[0];
        int max = nums[nums.length-1]; 
        int count = 0;
        for(int i=0; i < n; i++){
            if( nums[i] > min && nums[i] < max){
                count++;
            }
        }
    return count;
    }
}