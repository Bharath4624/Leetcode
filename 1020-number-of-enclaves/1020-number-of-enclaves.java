class pair{
    int row;
    int col;
    pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        vis[i][j]=1;
                        queue.add(new pair(i,j));
                    }
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!queue.isEmpty()){
            pair p=queue.poll();
            int row=p.row;
            int col=p.col;
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0 && grid[newrow][newcol]==1){
                    vis[newrow][newcol]=1;
                    queue.add(new pair(newrow,newcol));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}