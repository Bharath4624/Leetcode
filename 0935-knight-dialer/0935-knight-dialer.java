class Solution {
    private static final int mod=1000000007;
    private static final List<List<Integer>> adj=Arrays.asList(
        Arrays.asList(4,6),
        Arrays.asList(6,8),
        Arrays.asList(7,9),
        Arrays.asList(4,8),
        Arrays.asList(3,9,0),
        Arrays.asList(),
        Arrays.asList(1,7,0),
        Arrays.asList(2,6),
        Arrays.asList(1,3),
        Arrays.asList(2,4)
    );
    private int dp[][]=new int[5001][10];
    public int knightDialer(int n) {
        int result=0;
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        for(int i=0;i<=9;i++){
            result=(result+solve(n-1,i))%mod;
        }
        return result;
    }
    private int solve(int n,int cell){
        if(n==0){
            return 1;
        }
        if(dp[n][cell]!=-1){
            return dp[n][cell];
        }
        int ans=0;
        for(int i:adj.get(cell)){
            ans=(ans+solve(n-1,i))%mod;
        }
        return dp[n][cell]=ans;
    }
}