class Solution {
     private int getMaxStones(int[] piles,int[] suffixSum,int[][] dp,int i,int M)
    {
        int n=piles.length;
        if(i==n)
        {
            return 0;
        }
        if(2*M>=n-i)
        {
            return suffixSum[i];
        }
        if(dp[i][M]>0)
        {
            return dp[i][M];
        }
        int minStonesForBob=Integer.MAX_VALUE;
        for(int X=1;X<=2*M;X++)
        {
             minStonesForBob=Math.min(minStonesForBob,getMaxStones(piles,suffixSum,dp,i+X,Math.max(M,X)));
        }
        dp[i][M]=suffixSum[i]-minStonesForBob;
        return dp[i][M];
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        if(n==1)
        {
            return piles[0];
        }
        int[] suffixSum=new int[n];
        suffixSum[n-1]=piles[n-1];
        for(int i=n-2;i>=0;i--)
        {
            suffixSum[i]=suffixSum[i+1]+piles[i];
        }
        int[][] dp=new int[n][n+1];
        return getMaxStones(piles,suffixSum,dp,0,1);

    }
  
}
