class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum<target || (sum-target)%2!=0){
            return 0;
        }
        int newTarget = (sum - target)/2;
        int dp[][] = new int[n+1][newTarget+1];
	    
	    dp[0][0] = 1;
	    
	    
	    
	    for(int i=1;i<=n;i++){
	        for(int j=0;j<=newTarget;j++){
	            dp[i][j] = dp[i-1][j];
	            if(j-nums[i-1]>=0){
	                dp[i][j] += dp[i-1][j-nums[i-1]];
	            }
	        }
	    }
	    
	    return dp[n][newTarget];
    }
}