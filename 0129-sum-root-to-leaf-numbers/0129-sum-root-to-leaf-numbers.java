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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        preorder(root,0);
        return sum;
    }
    public void preorder(TreeNode root,int k){
        if(root==null){
            return;
        }
        k=k*10+root.val;
        if(root.left==null && root.right==null){
            sum+=k;
        }
        preorder(root.left,k);
        preorder(root.right,k);
    }
}