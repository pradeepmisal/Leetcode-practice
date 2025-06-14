class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int lt =0;
        
        //pushing non zero forward
        for(int i =0; i < n; i++){
            if(nums[i] != 0){
                nums[lt] = nums[i];// copies the value of array 
                lt++;
            }
        }
        //now just move zeros to end
        for(int i=lt; i<n; i++ ){
            
                nums[i] = 0; 
            
        }
    }
}