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
    public boolean isBalanced(TreeNode root) {
        if(maxDepth(root)==-1){
            return false;
        }
        return true;
    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftheight=maxDepth(root.left);
        int rightheight=maxDepth(root.right);
        if(leftheight==-1 || rightheight==-1){
            return -1;
        }
        if(Math.abs(leftheight-rightheight)>1){
            return -1;
        }
        return 1+Math.max(leftheight,rightheight);
    }
}