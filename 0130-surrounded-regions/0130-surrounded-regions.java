class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(0,i,vis,board);
            }
            if(vis[n-1][i]==0 && board[n-1][i]=='O'){
                dfs(n-1,i,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,vis,board);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,vis,board);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int i,int j,int[][] vis,char[][] board){
        int n=board.length;
        int m=board[0].length;
        vis[i][j]=1;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        for(int c=0;c<4;c++){
            int newrow=i+delrow[c];
            int newcol=j+delcol[c];
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0 && board[newrow][newcol]=='O'){
                dfs(newrow,newcol,vis,board);
            }
        }
    }
}