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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return buildTree(list, 0, list.size() - 1);
    }

    private TreeNode buildTree(List<Integer> list, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid  = (lo + hi) /2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildTree(list, lo, mid - 1);
        node.right = buildTree(list, mid + 1, hi);
        return node;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }


}