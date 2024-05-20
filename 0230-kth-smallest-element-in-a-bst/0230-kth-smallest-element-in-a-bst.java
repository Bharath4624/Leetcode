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
    // public int kthSmallest(TreeNode root, int k) {
    //     if(root==null){
    //         return root.val;
    //     }
    //     int[] small=new int[1];
    //     int count[]=new int[1];
    //     count[0]=0;
    //     inorder(root,k,small,count);
    //     return small[0];
    // }
    // public void inorder(TreeNode root,int k,int[] small,int[] count){
    //     if(root==null){
    //         return;
    //     }
    //     inorder(root.left,k,small,count);
    //     count[0]++;
    //     if(count[0]==k){
    //         small[0]=root.val;
    //         return;
    //     }
    //     inorder(root.right,k,small,count);
    // }
    public int kthSmallest(TreeNode root, int k){
        TreeNode curr=root;
        int count=0;
        while(curr!=null){
            if(curr.left==null){
                count++;
                if(count==k){
                    return curr.val;
                }
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    count++;
                    if(count==k){
                        return curr.val;
                    }
                    curr=curr.right;
                }
            }
        }
        return -1;
    }
}