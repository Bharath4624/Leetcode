class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int ini=image[sr][sc];
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        dfs(sr,sc,ini,color,delrow,delcol,image,ans);
        return ans;
    }
    public void dfs(int row,int col,int ini,int newcolour,int[] delrow,int[] delcol,int[][] image,int[][] ans){
        ans[row][col]=newcolour;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && image[newrow][newcol]==ini && ans[newrow][newcol]!=newcolour){
                dfs(newrow,newcol,ini,newcolour,delrow,delcol,image,ans);
            }
        }
    }
}