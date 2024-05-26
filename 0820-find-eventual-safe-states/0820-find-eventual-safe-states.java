class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis=new int[graph.length];
        int[] path=new int[graph.length];
        int[] check=new int[graph.length];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                dfs(i,vis,path,check,graph);
            }
        }
        for(int i=0;i<graph.length;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int node,int[] vis,int[] path,int[] check,int[][] graph){
        vis[node]=1;
        path[node]=1;
        for(int i:graph[node]){
            if(vis[i]==0){
                if(dfs(i,vis,path,check,graph)){
                    check[i]=0;
                    return true;
                }
            }
            else if(path[i]==1){
                check[i]=0;
                return true;
            }
        }
        path[node]=0;
        check[node]=1;
        return false;
    }
}