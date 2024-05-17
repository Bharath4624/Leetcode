/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class tuple{
    TreeNode node;
    int x;
    int y;
    tuple(TreeNode node,int x,int y){
        this.node=node;
        this.x=x;
        this.y=y;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> treemap=new TreeMap<>();
        Queue<tuple> queue=new LinkedList<>();
        queue.offer(new tuple(root,0,0));
        while(!queue.isEmpty()){
            tuple t=queue.poll();
            TreeNode node=t.node;
            int x=t.x;
            int y=t.y;
            if(!treemap.containsKey(x)){
                treemap.put(x,new TreeMap<>());
            }
            if(!treemap.get(x).containsKey(y)){
                treemap.get(x).put(y,new PriorityQueue<>());
            }
            treemap.get(x).get(y).offer(node.val);
            if(node.left!=null){
                queue.offer(new tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                queue.offer(new tuple(node.right,x+1,y+1));
            }
        }
        List<List<Integer>> list=new ArrayList<>();
            for(TreeMap<Integer,PriorityQueue<Integer>> map:treemap.values()){
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer> nodes:map.values()){
                    while(!nodes.isEmpty()){
                        list.get(list.size()-1).add(nodes.poll());
                    }
                }
            }
        return list;
    }
}