class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length-2;
        int[][] ans=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=max(grid,i,j);
            }
        }
        return ans;
    }
    public int max(int[][] arr,int r,int c){
        int max=Integer.MIN_VALUE;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                max=Math.max(max,arr[i][j]);
            }
        }
        return max;
    }
}