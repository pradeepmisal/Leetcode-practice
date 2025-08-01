class Solution {
    public long coloredCells(int n) {
        if(n==1)return 1;

        long count=0;
        for(int i=2;i<=n;i++)count+=2;
        
        long ans=(n*count)+1;
        return ans;
    }
}