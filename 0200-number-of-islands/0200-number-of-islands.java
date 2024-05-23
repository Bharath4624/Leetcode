class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,char[][] grid,int[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        if(col+1<m && vis[row][col+1]==0 && grid[row][col+1]=='1'){
            dfs(row,col+1,grid,vis);
        }
        if(col-1>=0 && vis[row][col-1]==0 && grid[row][col-1]=='1'){
            dfs(row,col-1,grid,vis);
        }
        if(row-1>=0 && vis[row-1][col]==0 && grid[row-1][col]=='1'){
            dfs(row-1,col,grid,vis);
        }
        if(row+1<n && vis[row+1][col]==0 && grid[row+1][col]=='1'){
            dfs(row+1,col,grid,vis);
        }
    }
}