/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parent(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                queue.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        parent(root,parent);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int count=0;
        queue.offer(target);
        visited.put(target,true);
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            if(count==k){
                break;
            }
            count++;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    visited.put(curr.left,true);
                    queue.offer(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    visited.put(curr.right,true);
                    queue.offer(curr.right);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    visited.put(parent.get(curr),true);
                    queue.offer(parent.get(curr));
                }
            }
        }
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            list.add(curr.val);
        }
        return list;
    }
}