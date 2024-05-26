class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int k=0;
        int[] ans=new int[V];
        while(!queue.isEmpty()){
            int node=queue.poll();
            ans[k++]=node;
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
        }
        if(k==V){
            return ans;
        }
        return new int[]{};
    }
}