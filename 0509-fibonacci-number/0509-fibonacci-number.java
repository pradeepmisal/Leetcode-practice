class Solution {
    public int fib(int n) {
     if(n==0){
         return 0;
     }
        if (n==1){
            return 1;
        }
        int firstTerm = 0;
        int secondTerm =1;
        
        for(int i =1; i<=n;i++){
            int thirdTerm =firstTerm + secondTerm;
            secondTerm= firstTerm;
            firstTerm = thirdTerm;
           
            
        }
         return firstTerm;
    }
}