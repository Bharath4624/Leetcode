class Solution {
    public int findCircleNum(int[][] isConnected) {
        int nodes=isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<nodes;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;
        int vis[]=new int[nodes];
        for(int i=0;i<nodes;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adj,vis);
            }
        }
        return count;
    }
    public static void dfs(int node,List<List<Integer>> adj,int[] vis){
        vis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                dfs(i,adj,vis);
            }
        }
    }
}