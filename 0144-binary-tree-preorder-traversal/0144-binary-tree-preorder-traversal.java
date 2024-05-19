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
    public List<Integer> preorderTraversal(TreeNode root) {
        // List<Integer> list=new ArrayList<>();
        // if(root==null){
        //     return list;
        // }
        // list.add(root.val);
        // list.addAll(preorderTraversal(root.left));
        // list.addAll(preorderTraversal(root.right));
        // return list;
        // List<Integer> preorder=new ArrayList<>();
        // if(root==null){
        //     return preorder;
        // }
        // Stack<TreeNode> stack=new Stack<>();
        // stack.push(root);
        // while(!stack.isEmpty()){
        //     root=stack.pop();
        //     preorder.add(root.val);
        //     if(root.right!=null){
        //         stack.push(root.right);
        //     }
        //     if(root.left!=null){
        //         stack.push(root.left);
        //     }
        // }
        // return preorder;
        List<Integer> list=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    list.add(curr.val);
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return list;
    }
}