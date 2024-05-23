class pair{
    int row;
    int col;
    int time;
    pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        Queue<pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int max=0;
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            int time=queue.peek().time;
            queue.remove();
            max=Math.max(time,max);
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0 && grid[newrow][newcol]!=0){
                    vis[newrow][newcol]=2;
                    queue.add(new pair(newrow,newcol,time+1));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=2 && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return max;
    }
}