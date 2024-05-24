class pair{
    int row;
    int col;
    int steps;
    pair(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];
        Queue<pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    vis[i][j]=1;
                    queue.add(new pair(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            int steps=queue.peek().steps;
            queue.remove();
            dist[row][col]=steps;
            int[] delrow={-1,0,1,0};
            int[] delcol={0,1,0,-1};
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0){
                    vis[newrow][newcol]=1;
                    queue.add(new pair(newrow,newcol,steps+1));
                }
            }
        }
        return dist;
    }
}