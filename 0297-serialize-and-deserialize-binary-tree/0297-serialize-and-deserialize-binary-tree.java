/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        Queue<TreeNode> queue=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null){
                sb.append("n ");
                continue;
            }
            sb.append(node.val+" ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }
        String[] arr=data.split(" ");
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        queue.offer(root);
        for(int i=1;i<arr.length;i++){
            TreeNode parent=queue.poll();
            if(!arr[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                parent.left=left;
                queue.offer(left);
            }
            if(!arr[++i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                parent.right=right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));