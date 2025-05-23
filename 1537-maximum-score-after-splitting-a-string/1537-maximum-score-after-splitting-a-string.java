class Solution {
    public int maxScore(String s) {
        int max=0;
        for(int i=0; i<s.length()-1; i++)
        {
            String left=s.substring(0,i+1);
            String right=s.substring(i+1);
            int localScore=count(left,'0')+count(right,'1');
            if(max<localScore)
                max=localScore;
        }
        return max;
    }
    int count(String l, char j)
    {
        int res=0;
        for(int i=0; i<l.length(); i++)
        {
            if(l.charAt(i)==j)
                res++;
        }
        return res;
    }
}