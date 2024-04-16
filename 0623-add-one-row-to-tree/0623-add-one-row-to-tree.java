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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return insert(root,val,depth,1);
    }
    public TreeNode insert(TreeNode root,int val,int depth,int curr){
        if(root==null){
            return null;
        }
        if(depth==1){
            TreeNode newnode=new TreeNode(val);
            newnode.left=root;
            return newnode;
        }
        if(curr==depth-1){
            TreeNode newnode=new TreeNode(val);
            newnode.left=root.left;
            root.left=newnode;
            newnode=new TreeNode(val);
            newnode.right=root.right;
            root.right=newnode;
        }
        else{
            insert(root.left,val,depth,curr+1);
            insert(root.right,val,depth,curr+1);
        }
        return root;
    }
}