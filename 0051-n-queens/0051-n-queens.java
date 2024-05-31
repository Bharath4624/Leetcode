class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> board=new ArrayList<>();
        String s=".".repeat(n);
        for(int i=0;i<n;i++){
            board.add(s);
        }
        int[] left=new int[n];
        Arrays.fill(left,0);
        int[] upperrow=new int[2*n-1];
        Arrays.fill(upperrow,0);
        int[] lowerrow=new int[2*n-1];
        Arrays.fill(lowerrow,0);
        solve(0,board,ans,left,upperrow,lowerrow,n);
        return ans;
    }
    public void solve(int col,List<String> board,List<List<String>> ans,int[] left,int[] upperrow,int[] lowerrow,int n){
        if(col==n){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(left[row]==0 && upperrow[n-1+col-row]==0 && lowerrow[row+col]==0){
                char[] arr=board.get(row).toCharArray();
                arr[col]='Q';
                board.set(row,new String(arr));
                left[row]=1;
                lowerrow[row+col]=1;
                upperrow[n-1+col-row]=1;
                solve(col+1,board,ans,left,upperrow,lowerrow,n);
                arr[col]='.';
                board.set(row,new String(arr));
                left[row]=0;
                lowerrow[row+col]=0;
                upperrow[n-1+col-row]=0;
            }
        }
    }
}