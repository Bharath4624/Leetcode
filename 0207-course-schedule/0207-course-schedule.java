class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
        while(!queue.isEmpty()){
            int node=queue.poll();
            k++;
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    queue.add(i);
                }
            }
        }
        return k==V;
    }
}