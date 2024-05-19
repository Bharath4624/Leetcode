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
class Solution {
    public int burn(Map<TreeNode,TreeNode> map,TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        Map<TreeNode,Integer> visited=new HashMap<>();
        queue.offer(root);
        visited.put(root,1);
        int max=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            int f=0;
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null && visited.get(temp.left)==null){
                    f=1;
                    queue.offer(temp.left);
                    visited.put(temp.left,1);
                }
                if(temp.right!=null && visited.get(temp.right)==null){
                    f=1;
                    queue.offer(temp.right);
                    visited.put(temp.right,1);
                }
                if(map.get(temp)!=null && visited.get(map.get(temp))==null){
                    f=1;
                    queue.offer(map.get(temp));
                    visited.put(map.get(temp),1);
                }
            }
            if(f==1){
                max++;
            }
        }
        return max;
    }
    public TreeNode parent(Map<TreeNode,TreeNode> map,TreeNode root,int k){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode temp=null;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.val==k){
                temp=node;
            }
            if(node.left!=null){
                map.put(node.left,node);
                queue.offer(node.left);
            }
            if(node.right!=null){
                map.put(node.right,node);
                queue.offer(node.right);
            }
        }
        return temp;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        TreeNode target=parent(map,root,start);
        int max=burn(map,target);
        return max;
    }
}