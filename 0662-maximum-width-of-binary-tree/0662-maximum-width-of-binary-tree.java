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
class Pair{
    TreeNode node;
    int data;
    Pair(TreeNode node,int data){
        this.node=node;
        this.data=data;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=0;
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            int min=queue.peek().data;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                int curr=queue.peek().data-min;
                TreeNode temp=queue.peek().node;
                queue.poll();
                if(i==0){
                    first=curr;
                }
                if(i==size-1){
                    last=curr;
                }
                if(temp.left!=null){
                    queue.offer(new Pair(temp.left,curr*2+1));
                }
                if(temp.right!=null){
                    queue.offer(new Pair(temp.right,curr*2+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}