class pair{
    int row;
    int col;
    pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        // int n=grid.length;
        // int m=grid[0].length;
        // int[][] vis=new int[n][m];
        // int count=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(grid[i][j]=='1' && vis[i][j]==0){
        //             dfs(i,j,grid,vis);
        //             count++;
        //         }
        //     }
        // }
        // return count;
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
    public void bfs(int row1,int col1,int[][] vis,char[][] grid){
        vis[row1][col1]=1;
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(row1,col1));
        int n=grid.length;
        int m=grid[0].length;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            queue.remove();
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0 && grid[newrow][newcol]=='1'){
                    vis[newrow][newcol]=1;
                    queue.add(new pair(newrow,newcol));
                }
            }
        }
    }
    // public void dfs(int row,int col,char[][] grid,int[][] vis){
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     vis[row][col]=1;
    //     ,col,grid,vis);
    //     }if(col+1<m && vis[row][col+1]==0 && grid[row][col+1]=='1'){
    //         dfs(row,col+1,grid,vis);
    //     }
    //     if(col-1>=0 && vis[row][col-1]==0 && grid[row][col-1]=='1'){
    //         dfs(row,col-1,grid,vis);
    //     }
    //     if(row-1>=0 && vis[row-1][col]==0 && grid[row-1][col]=='1'){
    //         dfs(row-1,col,grid,vis);
    //     }
    //     if(row+1<n && vis[row+1][col]==0 && grid[row+1][col]=='1'){
    //         dfs(row+1
    // }
}