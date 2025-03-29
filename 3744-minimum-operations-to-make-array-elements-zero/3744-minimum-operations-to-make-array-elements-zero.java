class Solution {

    public long calc(long l, long r)
    {
        long ans = 0;
        long curr = 1;
        long st = 0;
        long ed = 3;

        while(ed<l)
        {
            curr++;
            st = ed+1;
            ed = st*4 - 1;
        }

        while(r>ed)
        {
            ans += curr*(ed-l+1);
            curr++;
            l = ed+1;
            ed = (ed+1)*4 - 1;
        }

        ans+=(r-l+1)*curr;
        return (ans+1)/2;
    }

    public long minOperations(int[][] queries) {
        long ans = 0;
        for(int[] q: queries)
        {
            int l = q[0];
            int r = q[1];

            ans+=calc(l,r);
        }
        return ans;
    }
}