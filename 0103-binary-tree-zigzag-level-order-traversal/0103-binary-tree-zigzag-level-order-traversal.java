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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        boolean flag=true;
        while(!queue.isEmpty()){
            int n=queue.size();
            int[] list=new int[n];
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                int index=flag ? i:(n-i-1);
                list[index]=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            flag=!flag;
            List<Integer> arr = new ArrayList<>();
            for (int num : list) {
                arr.add(num);
            }
            ans.add(arr);

        }
        return ans;
    }
}