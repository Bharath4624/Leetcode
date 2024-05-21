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
 class BSTIterator {
    Stack<TreeNode> stack=new Stack<>();
    boolean reverse=true;
    public void pushall(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(reverse==false){
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
    }
    public BSTIterator(TreeNode root,boolean isreverse) {
        reverse=isreverse;
        pushall(root);
    }
    public int next() {
        TreeNode temp=stack.pop();
        if(reverse==false){
            pushall(temp.right);
        }
        else{
            pushall(temp.left);
        }
        return temp.val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left=new BSTIterator(root,false);
        BSTIterator right=new BSTIterator(root,true);
        int i=left.next();
        int j=right.next();
        while(i<j){
            if(i+j==k){
                return true;
            }
            else if(i+j<k){
                i=left.next();
            }
            else{
                j=right.next();
            }
        }
        return false;
    }
}