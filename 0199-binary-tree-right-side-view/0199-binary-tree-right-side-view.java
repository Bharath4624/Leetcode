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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        right(root,list,0);
        return list;
    }
    public void right(TreeNode node,List<Integer> list,int depth){
        if(node==null){
            return;
        }
        if(depth==list.size()){
            list.add(node.val);
        }
        right(node.right,list,depth+1);
        right(node.left,list,depth+1);
    }
}